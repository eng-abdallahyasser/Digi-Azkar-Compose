package com.abdallahyasser.digi_azkar.data.azkar

import com.abdallahyasser.digi_azkar.data.azkar.remote.AzkarApiService
import com.abdallahyasser.digi_azkar.data.azkar.remote.AzkarRetrofitClient
import com.abdallahyasser.digi_azkar.data.azkar.remote.toDomain
import com.abdallahyasser.digi_azkar.domain.azkar.AzkarRepositoryInter
import com.abdallahyasser.digi_azkar.domain.azkar.Zekr

class AzkarRepoImpl : AzkarRepositoryInter {
    override suspend fun getAzkar(): List<Zekr>  {
        return try {
            val apiService = AzkarRetrofitClient.createService(AzkarApiService::class.java)

            val azkarList = mutableListOf<Zekr>()
            azkarList.addAll(apiService.getEveningAzkar().toDomain("evening"))
            azkarList.addAll(apiService.getMorningAzkar().toDomain("morning"))
            azkarList.addAll(apiService.getPostPrayerAzkar().toDomain("post prayer"))

            azkarList


        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}