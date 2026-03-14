package com.abdallahyasser.digiazkarcompose.domain.prayer


interface PrayerRepoInterface{
    suspend fun getPrayerTimes(city: String = "Cairo", country: String = "Egypt"): List<Prayer>
}
