package com.abdallahyasser.digi_azkar.domain.prayer

import com.abdallahyasser.digi_azkar.data.prayer.PrayerRepoImpl
import com.abdallahyasser.digiazkarcompose.domain.prayer.Prayer
import com.abdallahyasser.digiazkarcompose.domain.prayer.PrayerRepoInterface
import javax.inject.Inject

class GetPrayerTimesUseCase @Inject constructor(val repo: PrayerRepoImpl) {

    suspend operator fun invoke(): List<Prayer> {
        return repo.getPrayerTimes()
    }

}
