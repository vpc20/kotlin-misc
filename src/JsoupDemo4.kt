//import kotlinx.coroutines.*
import org.jsoup.Jsoup
//import sun.rmi.server.Dispatcher
//import java.util.concurrent.ConcurrentLinkedQueue

fun main() {

    val doc =
        Jsoup.connect("https://techcrunch.com/2019/12/16/fashion-platform-zilingo-acquires-sri-lankan-saas-startup-ncinga-for-15-5m/")
            .get()
    val link = doc.select("meta[property=og:image]").attr("content")
    println(link)

//    doc =
//        Jsoup.connect("https://www.androidcentral.com/playstation-now-horizon-zero-dawn-uncharted-lost-legacy-overcooked-2?utm_source=feedburner&utm_medium=feed&utm_campaign=Feed%3A+androidcentral+%28Android+Central%29&utm_content=FeedBurner+user+view")
//            .get()
//    link = doc.select("meta[property=og:image]").attr("content")
//    println(link)
//
//    doc =
//        Jsoup.connect("https://edition.cnn.com/2019/12/17/politics/trump-north-korea/index.html")
//            .get()
//    link = doc.select("meta[property=og:image]").attr("content")
//    println(link)
//
//
//    doc =
//        Jsoup.connect("https://www.premierguitar.com/articles/29752-top-10-rig-rundowns-of-2010s")
//            .get()
//    link = doc.select("meta[property=og:image]").attr("content")
//    println(link)
}

//fun main() {
//
//    val linkList = ConcurrentLinkedQueue<String>()
//
//    runBlocking {
//        val mainJob = coroutineScope {
//            CoroutineScope(Dispatchers.IO).launch {
//                println(1)
//                val doc =
//                    Jsoup.connect("https://techcrunch.com/2019/12/16/fashion-platform-zilingo-acquires-sri-lankan-saas-startup-ncinga-for-15-5m/")
//                        .get()
//                val link = doc.select("meta[property=og:image]").attr("content")
//                linkList.add(link)
//                println(link)
//            }
//
//            CoroutineScope(Dispatchers.IO).launch {
//                println(2)
//                val doc =
//                    Jsoup.connect("https://www.androidcentral.com/playstation-now-horizon-zero-dawn-uncharted-lost-legacy-overcooked-2?utm_source=feedburner&utm_medium=feed&utm_campaign=Feed%3A+androidcentral+%28Android+Central%29&utm_content=FeedBurner+user+view")
//                        .get()
//                val link = doc.select("meta[property=og:image]").attr("content")
//                linkList.add(link)
//                println(link)
//            }
//
//            CoroutineScope(Dispatchers.IO).launch {
//                println(3)
//                val doc =
//                    Jsoup.connect("https://edition.cnn.com/2019/12/17/politics/trump-north-korea/index.html")
//                        .get()
//                val link = doc.select("meta[property=og:image]").attr("content")
//                linkList.add(link)
//                println(link)
//            }
//
//            CoroutineScope(Dispatchers.IO).launch {
//                println(4)
//                val doc =
//                    Jsoup.connect("https://www.premierguitar.com/articles/29752-top-10-rig-rundowns-of-2010s")
//                        .get()
//                val link = doc.select("meta[property=og:image]").attr("content")
//                linkList.add(link)
//                println(link)
//            }
//        }
//        mainJob.join()
//        println("mainJob.join()")
//        linkList.forEach { println(it) }
//        delay(10000L)
//    }
//}
