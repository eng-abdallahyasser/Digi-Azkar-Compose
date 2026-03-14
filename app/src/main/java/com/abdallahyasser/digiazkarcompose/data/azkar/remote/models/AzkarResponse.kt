package com.abdallahyasser.digi_azkar.data.azkar.remote.models

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
class AzkarResponse(
    val title: String,
    val content:List<ZekrResponse>
)

