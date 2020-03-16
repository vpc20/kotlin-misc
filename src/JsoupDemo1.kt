import org.jsoup.Jsoup
import org.jsoup.nodes.Document


fun main() {
    val doc: Document = Jsoup.connect("https://www.wikipedia.org/").get()
    val title: String = doc.title()
    println("Document title is $title")
}
