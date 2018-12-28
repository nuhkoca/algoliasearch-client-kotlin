package client.data

import client.serialize.Deserializer
import client.serialize.Serializer
import client.toAttribute
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull


data class Attribute(val name: String) {

    override fun toString(): String {
        return name
    }

    internal companion object : Serializer<Attribute>, Deserializer<Attribute> {

        override fun serialize(input: Attribute): JsonElement {
            return  JsonPrimitive(input.name)
        }

        override fun deserialize(element: JsonElement): Attribute? {
            return element.contentOrNull?.toAttribute()
        }
    }
}