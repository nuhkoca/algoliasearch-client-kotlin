package com.algolia.search.saas.data

import com.algolia.search.saas.serialize.KeyNotPublished
import com.algolia.search.saas.serialize.KeyPublished
import com.algolia.search.saas.serialize.asJsonInput
import com.algolia.search.saas.serialize.asJsonOutput
import kotlinx.serialization.*
import kotlinx.serialization.json.JsonLiteral
import kotlinx.serialization.json.JsonPrimitive


@Serializable(TaskStatus.Companion::class)
sealed class TaskStatus(override val raw: String) : Raw<String> {

    object Published : TaskStatus(KeyPublished)

    object NotPublished : TaskStatus(KeyNotPublished)

    data class Unknown(override val raw: String) : TaskStatus(raw)

    @Serializer(TaskStatus::class)
    companion object : KSerializer<TaskStatus> {

        override fun serialize(encoder: Encoder, obj: TaskStatus) {
            encoder.asJsonOutput().encodeJson(JsonPrimitive(obj.raw))
        }

        override fun deserialize(decoder: Decoder): TaskStatus {
            val element = decoder.asJsonInput() as JsonLiteral

            return when (val content = element.content) {
                KeyPublished -> Published
                KeyNotPublished -> NotPublished
                else -> Unknown(content)
            }
        }
    }
}