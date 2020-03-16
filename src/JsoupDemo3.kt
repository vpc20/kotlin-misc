import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element


fun main() {
    val html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>"
//    <p>
//       An
//       <a href='http://example.com/'>
//           <b>example</b>
//       </a>
//       link.
//    </p>

    val doc: Document = Jsoup.parse(html)
    val link: Element = doc.select("a").first()
    println(link) // <a href="http://example.com/"><b>example</b></a>

    val text: String = doc.body().text()
    println(text) // "An example link"

    val linkHref: String = link.attr("href")
    println(linkHref) // "http://example.com/"

    val linkText: String = link.text()
    println(linkText) // "example""

    val linkOuterH: String = link.outerHtml()
    println(linkOuterH) // <a href="http://example.com/"><b>example</b></a>

    val linkInnerH: String = link.html() // "<b>example</b>"
    println(linkInnerH) // "<b>example</b>"

}