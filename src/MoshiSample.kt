import com.squareup.moshi.*
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.lang.reflect.ParameterizedType


data class MarsProperty(
        val id: String,
        @Json(name = "img_src") val imgSrcUrl: String,
        val type: String,
        val price: Double
)

fun main(args: Array<String>) {

    val jsonStrSingle = "{\"price\":450000,\"id\":\"424905\",\"type\":\"buy\",\"img_src\":\"http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg\"}"

    val jsonStr = "[{\"price\":450000,\"id\":\"424905\",\"type\":\"buy\",\"img_src\":\"http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg\"}," +
            "{\"price\":8000000,\"id\":\"424906\",\"type\":\"rent\",\"img_src\":\"http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000ML0044631300305227E03_DXXX.jpg\"}," +
            "{\"price\":11000000,\"id\":\"424907\",\"type\":\"rent\",\"img_src\":\"http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631290503689E01_DXXX.jpg\"}," +
            "{\"price\":8000000,\"id\":\"424908\",\"type\":\"rent\",\"img_src\":\"http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000ML0044631290305226E03_DXXX.jpg\"}," +
            "{\"price\":12000000,\"id\":\"424909\",\"type\":\"rent\",\"img_src\":\"http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631280503688E0B_DXXX.jpg\"}]"

    val moshi: Moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    println("Json - one entry only")
    val jsonAdapter: JsonAdapter<MarsProperty> = moshi.adapter(MarsProperty::class.java)
    val property: MarsProperty? = jsonAdapter.fromJson(jsonStrSingle)
    println(property)

    println("\nJson - multiple entries")
    val parameterizedType: ParameterizedType = Types.newParameterizedType(List::class.java, MarsProperty::class.java)
    val adapter: JsonAdapter<List<MarsProperty>> = moshi.adapter(parameterizedType)
    val propertyList = adapter.fromJson(jsonStr)
    propertyList!!.forEach { println(it) }

}
