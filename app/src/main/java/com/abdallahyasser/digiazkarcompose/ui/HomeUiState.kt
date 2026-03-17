package com.abdallahyasser.digiazkarcompose.ui

import com.abdallahyasser.digiazkarcompose.domain.prayer.Prayer

data class HomeUiState(
    val prayerLoading:Boolean,
    val nextPrayerName:String,
    val nextPrayerTime:String,
    val remainingTime:String,
    val progress:Int,
    val prayerTimes:List<Prayer>,
    val ayahLoading:Boolean,
    val ayah: String,
    val sora: String
)