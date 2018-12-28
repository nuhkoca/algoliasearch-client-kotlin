package client.data

import client.serialize.Deserializer
import client.serialize.KeyAlpha
import client.serialize.KeyCount
import client.serialize.Serializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull


sealed class SortFacetValuesBy(open val raw: String) {

    /**
     * FacetFilter values are sorted by decreasing count.
     * The count is the number of records containing this facet value in the results of the query.
     */
    object Count : SortFacetValuesBy(KeyCount)

    /**
     * FacetFilter values are sorted in alphabetical order, ascending from A to Z.
     * The count is the number of records containing this facet value in the results of the query.
     */
    object Alpha : SortFacetValuesBy(KeyAlpha)

    data class Unknown(override val raw: String) : SortFacetValuesBy(raw)

    override fun toString(): String {
        return raw
    }

    internal companion object : Serializer<SortFacetValuesBy>, Deserializer<SortFacetValuesBy> {

        override fun serialize(input: SortFacetValuesBy): JsonElement {
            return JsonPrimitive(input.raw)
        }

        override fun deserialize(element: JsonElement): SortFacetValuesBy? {
            return when (val content = element.contentOrNull) {
                KeyCount -> Count
                KeyAlpha -> Alpha
                null -> null
                else -> Unknown(content)
            }
        }
    }
}