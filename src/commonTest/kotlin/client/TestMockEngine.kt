package client

import com.algolia.search.client.ClientSearch
import com.algolia.search.configuration.ConfigurationSearch
import com.algolia.search.helper.toAPIKey
import com.algolia.search.helper.toApplicationID
import com.algolia.search.model.IndexName
import com.algolia.search.model.response.ResponseSearch
import com.algolia.search.serialize.JsonNoDefaults
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.io.ByteReadChannel
import runBlocking
import shouldEqual
import kotlin.test.Test


internal class TestMockEngine {

    private val apiKey = "apiKey".toAPIKey()
    private val appID = "appID".toApplicationID()
    private val responseSearch = ResponseSearch(hitsOrNull = listOf())
    private val engine = MockEngine {
        respond(
            status = HttpStatusCode.OK,
            headers = headersOf("Content-Type", listOf(ContentType.Application.Json.toString())),
            content = ByteReadChannel(JsonNoDefaults.stringify(ResponseSearch.serializer(), responseSearch))
        )
    }
    private val client = ClientSearch(ConfigurationSearch(appID, apiKey, engine = engine))

    @Test
    fun mock() {
        runBlocking {
            client.initIndex(IndexName("index_name")).search() shouldEqual responseSearch
        }
    }
}