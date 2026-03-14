package com.abdallahyasser.digi_azkar.data.prayer.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Timings(
    @Json(name = "Fajr")
    val fajr: String,
    @Json(name = "Sunrise")
    val sunrise: String,
    @Json(name = "Dhuhr")
    val dhuhr: String,
    @Json(name = "Asr")
    val asr: String,
    @Json(name = "Sunset")
    val sunset: String,
    @Json(name = "Maghrib")
    val maghrib: String,
    @Json(name = "Isha")
    val isha: String,
    @Json(name = "Imsak")
    val imsak: String,
    @Json(name = "Midnight")
    val midnight: String,
    @Json(name = "Firstthird")
    val firstthird: String,
    @Json(name = "Lastthird")
    val lastthird: String
)