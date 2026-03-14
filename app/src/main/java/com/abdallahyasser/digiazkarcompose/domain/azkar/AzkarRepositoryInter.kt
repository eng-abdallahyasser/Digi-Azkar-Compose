package com.abdallahyasser.digi_azkar.domain.azkar

interface AzkarRepositoryInter {
    suspend fun getAzkar(): List<Zekr>
}