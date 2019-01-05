package com.algolia.search.saas.data

import com.algolia.search.saas.serialize.asJsonInput
import com.algolia.search.saas.serialize.asJsonOutput
import kotlinx.serialization.*
import kotlinx.serialization.json.*


@Serializable(BooleanOrQueryLanguages.Companion::class)
sealed class BooleanOrQueryLanguages {

    data class Boolean(val boolean: kotlin.Boolean) : BooleanOrQueryLanguages()

    data class QueryLanguages(val queryLanguages: List<QueryLanguage>) :
        BooleanOrQueryLanguages() {

        constructor(vararg queryLanguage: QueryLanguage) : this(queryLanguage.toList())
    }

    @Serializer(BooleanOrQueryLanguages::class)
    internal companion object : KSerializer<BooleanOrQueryLanguages> {

        override fun serialize(encoder: Encoder, obj: BooleanOrQueryLanguages) {
            val element = when (obj) {
                is Boolean -> JsonPrimitive(obj.boolean)
                is QueryLanguages -> jsonArray { obj.queryLanguages.forEach { +it.raw } }
            }

            encoder.asJsonOutput().encodeJson(element)
        }

        override fun deserialize(decoder: Decoder): BooleanOrQueryLanguages {
            val element = decoder.asJsonInput()

            return when (element) {
                is JsonArray -> QueryLanguages(element.map { QueryLanguage.convert(it.content) })
                is JsonLiteral -> Boolean(element.boolean)
                else -> throw Exception()
            }
        }
    }
}