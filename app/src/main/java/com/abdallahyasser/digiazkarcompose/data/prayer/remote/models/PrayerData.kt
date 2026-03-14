package com.abdallahyasser.digi_azkar.data.prayer.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PrayerData(
    @Json(name = "timings")
    val timings: Timings,
    @Json(name = "date")
    val date: DateInfo,
    @Json(name = "meta")
    val meta: Meta
)
