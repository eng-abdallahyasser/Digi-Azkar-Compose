package com.abdallahyasser.digi_azkar.data.azkar.remote

import com.abdallahyasser.digi_azkar.data.azkar.remote.models.AzkarResponse
import com.abdallahyasser.digi_azkar.domain.azkar.Zekr

fun AzkarResponse.toDomain(category: String) : List<Zekr> {

    val azkarList = mutableListOf<Zekr>()

    this.content.forEach { zekr ->
        azkarList.add(
            Zekr(
                zekrTitle = "zekrTitle",
                zekrText = zekr.zekr,
                repeat = zekr.repeat,
                bless = zekr.bless,
                reference = "reference",
                category =category,
            )
        )
    }

    return azkarList
}