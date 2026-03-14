package com.abdallahyasser.digi_azkar.data.prayer.remote.api

import com.abdallahyasser.digi_azkar.data.prayer.remote.models.PrayerTimesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PrayerTimesApi {
    @GET("v1/timingsByCity")
    suspend fun getPrayerTimesByCity(
        @Query("city") city: String,
        @Query("country") country: String
    ): PrayerTimesResponse
}

