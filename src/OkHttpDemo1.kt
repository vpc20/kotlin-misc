//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.Request


fun main() {

    val client = OkHttpClient()
    val request: Request = Request.Builder()
        .url("https://www.premierguitar.com/rss/articles")
        .build()
    try {
        val response = client.newCall(request).execute()
        println(response.body().toString())
    } catch (e: Exception) {
        println(e)
    }

}