package com.abdallahyasser.digi_azkar.data.prayer.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Month(
    @Json(name = "number")
    val number: Int,
    @Json(name = "en")
    val en: String,
    @Json(name = "ar")
    val ar: String? = null,
    @Json(name = "days")
    val days: Int? = null
)
