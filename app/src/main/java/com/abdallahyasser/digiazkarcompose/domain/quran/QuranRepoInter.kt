package com.abdallahyasser.digi_azkar.domain.quran

interface QuranRepoInter {

    suspend fun getSora(soraNumber: Int): Sorah

    suspend fun getAyah( ayahNumber: Int): Ayah


}