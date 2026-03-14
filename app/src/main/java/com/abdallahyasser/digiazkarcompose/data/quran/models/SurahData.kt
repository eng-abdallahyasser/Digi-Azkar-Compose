package com.abdallahyasser.digi_azkar.data.quran.models

data class SurahData(
    val number: Int,
    val name: String,
    val englishName: String,
    val englishNameTranslation: String,
    val revelationType: String,
    val numberOfAyahs: Int,
    val ayahs: List<Ayah>,
    val edition: Edition
)
