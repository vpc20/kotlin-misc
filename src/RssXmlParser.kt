import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.StringReader

data class RssData(
        val title: String?,
        val link: String?,
        val pubDate: String?,
        val description: String?,
        val contentImg: String?
)

class RssXmlParser {
    fun parse(inputReader: StringReader): List<RssData> {
        val listRssData = mutableListOf<RssData>()
        val xmlPullParserFactory = XmlPullParserFactory.newInstance()
        val parser: XmlPullParser = xmlPullParserFactory.newPullParser()
        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
        parser.setInput(inputReader)
        while (parser.next() != XmlPullParser.END_DOCUMENT) {
            if (parser.eventType == XmlPullParser.START_TAG) {
                if (parser.name == "item")
                    listRssData.add(readItems(parser))
            }
        }
        return listRssData
    }

    private fun readItems(parser: XmlPullParser): RssData {
        var title: String? = null
        var link: String? = null
        var pubDate: String? = null
        var description: String? = null
        var contentImg: String? = null
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.eventType == XmlPullParser.START_TAG) {
                when (parser.name) {
                    "title" -> title = readText(parser)
                    "link" -> link = readText(parser)
                    "pubDate" -> pubDate = readText(parser)
                    "description" -> description = readText(parser)
                    "content:encoded" -> contentImg = readImgSrc(parser)
                    else -> skip(parser)
                }
            }
        }
        return RssData(title, link, pubDate, description, contentImg)
    }

    private fun readImgSrc(parser: XmlPullParser): String? {
        val contentText = parser.nextText()
        var startIdx = -1
        var endIdx = -1
        val startImgIdx = contentText.indexOf("img src")

        for (i in (startImgIdx + 8)..contentText.lastIndex) {
            if (contentText[i] == '"') {
                if (startIdx == -1)
                    startIdx = i + 1
                else {
                    endIdx = i - 1
                    break
                }
            }
        }
        return contentText.slice(startIdx..endIdx)
    }


    private fun readText(parser: XmlPullParser): String {
        var result = ""
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.text
            parser.next()
        }
        return result
    }

    private fun skip(parser: XmlPullParser) {
        var depth = 1
        while (depth != 0) {
            when (parser.next()) {
                XmlPullParser.START_TAG -> depth++
                XmlPullParser.END_TAG -> depth--
            }
        }
    }
}
