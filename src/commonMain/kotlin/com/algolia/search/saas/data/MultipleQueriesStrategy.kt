package com.algolia.search.saas.data

import com.algolia.search.saas.serialize.KeyNone
import com.algolia.search.saas.serialize.KeyStopIfEnoughMatches
import com.algolia.search.saas.serialize.asJsonInput
import com.algolia.search.saas.serialize.asJsonOutput
import kotlinx.serialization.*
import kotlinx.serialization.json.JsonLiteral
import kotlinx.serialization.json.JsonPrimitive


@Serializable(MultipleQueriesStrategy.Companion::class)
sealed class MultipleQueriesStrategy(override val raw: String) : Raw<String> {

    object None : MultipleQueriesStrategy(KeyNone)

    object StopIfEnoughMatches : MultipleQueriesStrategy(KeyStopIfEnoughMatches)

    data class Unknown(override val raw: String) : MultipleQueriesStrategy(raw)

    override fun toString(): String {
        return raw
    }

    @Serializer(MultipleQueriesStrategy::class)
    internal companion object : KSerializer<MultipleQueriesStrategy> {

        override fun serialize(encoder: Encoder, obj: MultipleQueriesStrategy) {
            encoder.asJsonOutput().encodeJson(JsonPrimitive(obj.raw))
        }

        override fun deserialize(decoder: Decoder): MultipleQueriesStrategy {
            val element = decoder.asJsonInput() as JsonLiteral

            return when (val content = element.content) {
                KeyNone -> None
                KeyStopIfEnoughMatches -> StopIfEnoughMatches
                else -> Unknown(content)
            }
        }
    }
}