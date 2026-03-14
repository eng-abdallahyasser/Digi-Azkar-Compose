package com.abdallahyasser.digi_azkar.data.prayer.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DateInfo(
    @Json(name = "readable")
    val readable: String,
    @Json(name = "timestamp")
    val timestamp: String,
    @Json(name = "hijri")
    val hijri: HijriDate,
    @Json(name = "gregorian")
    val gregorian: GregorianDate
)
