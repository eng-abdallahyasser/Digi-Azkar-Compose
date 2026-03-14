package com.abdallahyasser.digi_azkar.data.azkar.remote.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ZekrResponse(
    val zekr: String,
    val bless: String,
    val repeat: Int)