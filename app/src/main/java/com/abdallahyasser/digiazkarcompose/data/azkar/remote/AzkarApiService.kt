package com.abdallahyasser.digi_azkar.data.azkar.remote


import com.abdallahyasser.digi_azkar.data.azkar.remote.models.AzkarResponse
import retrofit2.http.GET

interface AzkarApiService {
    @GET("json/azkar_sabah.json")
    suspend fun getMorningAzkar(): AzkarResponse

    @GET("json/azkar_massa.json")
    suspend fun getEveningAzkar(): AzkarResponse

    @GET("json/PostPrayer_azkar.json")
    suspend fun getPostPrayerAzkar(): AzkarResponse
}
