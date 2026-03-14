package com.abdallahyasser.digi_azkar.domain.prayer

import com.abdallahyasser.digiazkarcompose.domain.prayer.Prayer
import com.abdallahyasser.digiazkarcompose.domain.prayer.PrayerRepoInterface

class GetPrayerTimesUseCase(val repo: PrayerRepoInterface) {

    suspend operator fun invoke(): List<Prayer> {
        return repo.getPrayerTimes()
    }

}
