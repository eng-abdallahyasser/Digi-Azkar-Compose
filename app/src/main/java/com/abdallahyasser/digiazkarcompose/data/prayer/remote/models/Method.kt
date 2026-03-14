package com.abdallahyasser.digi_azkar.data.prayer.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Method(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "params")
    val params: Map<String, Double>,
    @Json(name = "location")
    val location: Location
)
