package com.algolia.search

import com.algolia.search.model.*
import com.algolia.search.model.APIKey
import com.algolia.search.model.ClusterName
import com.algolia.search.model.task.TaskID
import com.algolia.search.model.enums.Point
import com.algolia.search.model.enums.Snippet
import com.algolia.search.model.search.Cursor


fun String.toIndexName(): IndexName {
    return IndexName(this)
}

fun String.toAttribute(): Attribute {
    return Attribute(this)
}

fun String.toCursor(): Cursor {
    return Cursor(this)
}

fun String.toObjectID(): ObjectID {
    return ObjectID(this)
}

fun Long.toTaskID(): TaskID {
    return TaskID(this)
}

fun String.toUserID(): UserID {
    return UserID(this)
}

fun String.toApplicationID(): ApplicationID {
    return ApplicationID(this)
}

fun String.toAPIKey(): APIKey {
    return APIKey(this)
}

fun String.toClusterName(): ClusterName {
    return ClusterName(this)
}


infix fun Float.to(longitude: Float): Point {
    return Point(this, longitude)
}

infix fun Attribute.to(numberOfWords: Int?): Snippet {
    return Snippet(this, numberOfWords)
}