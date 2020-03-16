
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

fun main() {

    val doc: Document = Jsoup.connect("http://www.javatpoint.com").get()
    val keywords: String = doc.select("meta[name=keywords]").first().attr("content")
    println("Meta keyword : $keywords")
    val description: String = doc.select("meta[name=description]")[0].attr("content")
    println("Meta description : $description")

}