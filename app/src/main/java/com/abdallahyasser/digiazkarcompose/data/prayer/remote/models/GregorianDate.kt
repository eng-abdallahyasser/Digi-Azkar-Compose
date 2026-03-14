package com.abdallahyasser.digi_azkar.data.prayer.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GregorianDate(
    @Json(name = "date")
    val date: String,
    @Json(name = "format")
    val format: String,
    @Json(name = "day")
    val day: String,
    @Json(name = "weekday")
    val weekday: Weekday,
    @Json(name = "month")
    val month: Month,
    @Json(name = "year")
    val year: String
)
