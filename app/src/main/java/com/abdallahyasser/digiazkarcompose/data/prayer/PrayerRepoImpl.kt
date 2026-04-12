package com.abdallahyasser.digi_azkar.data.prayer

import com.abdallahyasser.digi_azkar.data.prayer.remote.PrayerRetrofitClient
import com.abdallahyasser.digi_azkar.data.prayer.remote.api.PrayerTimesApi
import com.abdallahyasser.digi_azkar.data.prayer.remote.toDomain
import com.abdallahyasser.digiazkarcompose.domain.prayer.Prayer
import com.abdallahyasser.digiazkarcompose.domain.prayer.PrayerRepoInterface
import javax.inject.Inject

class PrayerRepoImpl @Inject constructor(): PrayerRepoInterface {
    private val prayerTimesApi = PrayerRetrofitClient.createService(PrayerTimesApi::class.java)

    override suspend fun getPrayerTimes(city: String, country: String): List<Prayer> {
        return try {
            val response = prayerTimesApi.getPrayerTimesByCity(city, country)

            if (response.code == 200 && response.status == "OK") {
                response.toDomain()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

}