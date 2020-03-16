import java.io.File
import java.io.StringReader

fun main(args: Array<String>) {
    val xmlfile = File("C:\\Users\\vpc\\KotlinProjects\\XmlPullParserDemo\\src\\main\\kotlin\\rss.xml")
    val s = xmlfile.readText()
    val inputReader = StringReader(s)
    val rssDataList= RssXmlParser().parse(inputReader)
//    rssDataList.forEach(::println)
    for (e in rssDataList) {
        println("\n${"*".repeat(128)}")
        println("RSSData")
        println("title = ${e.title}")
        println("link = ${e.link}")
        println("pubDate = ${e.pubDate}")
        println("contentImg = ${e.contentImg}")
    }
    println("\n\nrssDataList.size = ${rssDataList.size}")
}