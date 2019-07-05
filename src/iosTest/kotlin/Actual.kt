import com.algolia.search.client.ClientAnalytics
import com.algolia.search.client.ClientInsights
import com.algolia.search.client.ClientPlaces
import com.algolia.search.client.ClientSearch
import com.algolia.search.helper.toAPIKey
import com.algolia.search.helper.toApplicationID
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.toKString
import kotlinx.coroutines.CoroutineScope
import platform.posix.*
import kotlin.coroutines.CoroutineContext


internal actual val clientSearch = ClientSearch(
    getenv("ALGOLIA_APPLICATION_ID_1")!!.toKString().toApplicationID(),
    getenv("ALGOLIA_SEARCH_KEY_1")!!.toKString().toAPIKey()
)
internal actual val clientAdmin1 = ClientSearch(
    getenv("ALGOLIA_APPLICATION_ID_1")!!.toKString().toApplicationID(),
    getenv("ALGOLIA_ADMIN_KEY_1")!!.toKString().toAPIKey()
)
internal actual val clientAdmin2 = ClientSearch(
    getenv("ALGOLIA_APPLICATION_ID_2")!!.toKString().toApplicationID(),
    getenv("ALGOLIA_ADMIN_KEY_2")!!.toKString().toAPIKey()
)
internal actual val clientMcm = ClientSearch(
    getenv("ALGOLIA_ADMIN_ID_MCM")!!.toKString().toApplicationID(),
    getenv("ALGOLIA_ADMIN_KEY_MCM")!!.toKString().toAPIKey()
)
internal actual val clientAnalytics = ClientAnalytics(
    getenv("ALGOLIA_APPLICATION_ID_1")!!.toKString().toApplicationID(),
    getenv("ALGOLIA_ADMIN_KEY_1")!!.toKString().toAPIKey()
)
internal actual val clientInsights = ClientInsights(
    getenv("ALGOLIA_APPLICATION_ID_1")!!.toKString().toApplicationID(),
    getenv("ALGOLIA_ADMIN_KEY_1")!!.toKString().toAPIKey()
)
internal actual val clientPlaces = ClientPlaces(
    getenv("ALGOLIA_PLACES_APP_ID")!!.toKString().toApplicationID(),
    getenv("ALGOLIA_PLACES_KEY")!!.toKString().toAPIKey()
)

internal actual val username: String
    get() {
        return try {
            "qlitzler"
        } catch (exception: Exception) {
            "unknown"
        }
    }

internal actual fun runBlocking(coroutineContext: CoroutineContext, block: suspend CoroutineScope.() -> Unit) {
    kotlinx.coroutines.runBlocking(coroutineContext, block = block)
}

internal actual object DateFormat {

    //    private val dateFormat = SimpleDateFormat("YYYY-MM-dd-HH-mm-ss").also {
//        it.timeZone = TimeZone.getTimeZone("UTC")
//    }
//
    actual fun format(timestamp: Long?): String {
        return timestamp.toString()
//        return dateFormat.format(if (timestamp != null) Date(timestamp) else Date())
    }

    actual fun parse(date: String): Long {
        return date.toLong()
//        return dateFormat.parse(date).time
    }
}

internal actual fun loadScratch(name: String): String {
    return readFile("src/commonTest/resources/$name")
}


fun readFile(name: String): String {
    val stringBuilder = StringBuilder()
//    val file = fopen(name, "r")!!
//
//    try {
//        memScoped {
//            val bufferLength = 64 * 1024
//            val buffer = allocArray<ByteVar>(bufferLength)
//
//            while (true) {
//                val nextLine = fgets(buffer, bufferLength, file)?.toKString()
//                if (nextLine == null || nextLine.isEmpty()) break
//                stringBuilder.append(nextLine)
//            }
//        }
//    } finally {
//        fclose(file)
//    }
    return stringBuilder.toString()
}


//fun parseLine(line: String, separator: Char): List<String> {
//    val result = mutableListOf<String>()
//    val builder = StringBuilder()
//    var quotes = 0
//    for (ch in line) {
//        when {
//            ch == '\"' -> {
//                quotes++
//                builder.append(ch)
//            }
//            (ch == '\n') || (ch == '\r') -> {
//            }
//            (ch == separator) && (quotes % 2 == 0) -> {
//                result.add(builder.toString())
//                builder.setLength(0)
//            }
//            else -> builder.append(ch)
//        }
//    }
//    return result
//}