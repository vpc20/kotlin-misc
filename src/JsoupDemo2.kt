import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File


fun main() {
    val input = File("C:\\Users\\vpc\\KotlinProjects\\KotlinMisc\\src\\Wikipedia.html")
    val doc: Document = Jsoup.parse(input, "UTF-8", "")
    println(doc.title())
    println(doc.select("link[rel='shortcut icon']").attr("href"))

    // a with href
    val links  = doc.select("a[href]")
    links.take(3).forEach { println(it) }

    // img with src ending .png
    val pngs = doc.select("img[src*=.png]")
    pngs.forEach(::println)

    // div with class=masthead
    val masthead  = doc.select("div.masthead").first()
    println(masthead)

    // direct a after h3
    val resultLinks = doc.select("h3.r > a")
    resultLinks.forEach(::println)


}