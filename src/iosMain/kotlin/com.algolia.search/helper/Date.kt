package com.algolia.search.helper



internal actual object DateISO8601 {

//    val dateISO8601 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").apply {
//        timeZone = TimeZone.getTimeZone("UTC")
//    }
//
//    val dateISO8601Millis = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").apply {
//        timeZone = TimeZone.getTimeZone("UTC")
//    }

    actual fun format(timestamp: Long, inMilliseconds: Boolean): String {
        return ""
    }

    actual fun parse(date: String, inMilliseconds: Boolean): Long {
        return 0
    }
}