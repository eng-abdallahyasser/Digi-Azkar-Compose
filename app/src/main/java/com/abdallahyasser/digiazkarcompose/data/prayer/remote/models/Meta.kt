package com.abdallahyasser.digi_azkar.data.prayer.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meta(
    @Json(name = "latitude")
    val latitude: Double,
    @Json(name = "longitude")
    val longitude: Double,
    @Json(name = "timezone")
    val timezone: String,
    @Json(name = "method")
    val method: Method,
    @Json(name = "latitudeAdjustmentMethod")
    val latitudeAdjustmentMethod: String,
    @Json(name = "midnightMode")
    val midnightMode: String,
    @Json(name = "school")
    val school: String
)
