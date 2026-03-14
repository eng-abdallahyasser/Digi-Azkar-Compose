package com.abdallahyasser.digi_azkar.data.prayer.remote

import com.abdallahyasser.digi_azkar.data.prayer.remote.models.PrayerTimesResponse
import com.abdallahyasser.digiazkarcompose.domain.prayer.Prayer


fun PrayerTimesResponse.toDomain(): List<Prayer> {
    val timings = this.data.timings
    return listOf(
        Prayer("Fajr", timings.fajr),
        Prayer("Sunrise", timings.sunrise),
        Prayer("Dhuhr", timings.dhuhr),
        Prayer("Asr", timings.asr),
        Prayer("Sunset", timings.sunset),
        Prayer("Maghrib", timings.maghrib),
        Prayer("Isha", timings.isha),
        Prayer("Imsak", timings.imsak),
        Prayer("Midnight", timings.midnight),
        Prayer("Firstthird", timings.firstthird),
        Prayer("Lastthird", timings.lastthird)
    )
}