import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

fun main() {
    val url = "https://jsonplaceholder.typicode.com/todos/1"
    val client = OkHttpClient()

    val request = Request.Builder()
        .url(url)
        .build()

    client.newCall(request).execute().use { response ->
        if (response.isSuccessful) {
            val data = response.body?.string()
            if (data != null) {
                val json = JSONObject(data)
                println("Title: ${json.getString("title")}")
            }
        } else {
            println("error: ${response.code}")
        }
    }
}
