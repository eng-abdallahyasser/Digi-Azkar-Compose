package com.abdallahyasser.digi_azkar.data.quran.api

import com.abdallahyasser.digi_azkar.data.quran.models.Ayah
import com.abdallahyasser.digi_azkar.data.quran.models.SurahData
import retrofit2.http.GET
import retrofit2.http.Query

interface QuramApiSevice {

    @GET("surah/1")
    suspend fun getSorah(): SurahData


    @GET("ayah/")
    suspend fun getAyah(@Query("ayah") ayah: Int): Ayah
}