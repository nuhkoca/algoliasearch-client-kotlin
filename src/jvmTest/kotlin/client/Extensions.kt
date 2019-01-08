package client

import com.algolia.search.saas.client.AlgoliaClient
import com.algolia.search.saas.data.*
import kotlinx.serialization.Serializable

internal val apiKey = ApiKey(System.getenv("MULTIPLATFORM_API_KEY"))
internal val applicationId = ApplicationID(System.getenv("MULTIPLATFORM_APP_ID"))
internal val algolia = AlgoliaClient(applicationId, apiKey)
internal val index = algolia.getIndex(IndexName("products_android_demo"))
internal val indexCopyA = algolia.getIndex(IndexName("products_android_demo_copyA"))
internal val indexCopyB = algolia.getIndex(IndexName("products_android_demo_copyB"))

@Serializable
internal data class Data(
    val name: String,
    val count: Int,
    val brands: List<String>,
    override val objectID: ObjectID
) : Indexable

internal val name = Attribute("name")
internal val count = Attribute("count")
internal val brands = Attribute("brands")
internal val iphone = "iPhone"
internal val samsung = "Samsung"
internal val dataCreate = Data("Phone", 1000, listOf(iphone), ObjectID("test_suite"))
internal val dataUpdate = dataCreate.copy(name = "Telephone")