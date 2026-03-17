package com.abdallahyasser.digiazkarcompose.ui

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdallahyasser.digi_azkar.data.prayer.PrayerRepoImpl
import com.abdallahyasser.digi_azkar.domain.prayer.GetPrayerTimesUseCase
import com.abdallahyasser.digiazkarcompose.domain.prayer.Prayer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale
import java.util.concurrent.TimeUnit
import kotlin.compareTo
import kotlin.text.compareTo

class HomeViewModel : ViewModel() {

    private val _homeUiState = MutableStateFlow(
        HomeUiState(
            true, "", "", "", 0, emptyList(), true, "", "",
        )
    )
    val homeUiState = _homeUiState.asStateFlow()


    val prayerTimes = mutableStateOf<List<Prayer>>(emptyList())

    init {
        viewModelScope.launch {
            try {
                prayerTimes.value = GetPrayerTimesUseCase(PrayerRepoImpl()).invoke()
                Log.d("HomeViewModel", "Prayer Times: ${prayerTimes.value.size}")
            } catch (e: Exception) {
                Log.d("HomeViewModel", "Error: ${e.message}")
            }
        }
    }

    fun getPrayerTime(prayerName: String): String {
        prayerTimes.value.find { it.prayerName.equals(prayerName, ignoreCase = true) }?.let {
            return it.prayerTime
        }
        return "XX:XX"
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun getNextPrayer(): Prayer {

        val now = LocalTime.now().let { it.hour * 60 + it.minute }

        for (prayer in prayerTimes.value) {
            val prayerTimeInMinutes = prayer.getTimeAsMinutes()
            if (prayerTimeInMinutes > now) {
                return Prayer(prayer.mapNextPrayerName(), prayer.prayerTime)
            }
        }
        return prayerTimes.value.first()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getRemainingTimeToNextPrayer(): String {
        val nextPrayer = getNextPrayer()
        val currentTime = Calendar.getInstance()

        val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
        val parsedTime = formatter.parse(nextPrayer.prayerTime) ?: return "لم يحسب"

        // Create a calendar for the parsed time
        val parsedCal = Calendar.getInstance().apply {
            time = parsedTime
        }

        // Set nextTime to TODAY but with the parsed hour and minute
        val nextTime = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, parsedCal.get(Calendar.HOUR_OF_DAY))
            set(Calendar.MINUTE, parsedCal.get(Calendar.MINUTE))
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)

            // If next prayer is Fajr and the time has passed, add 1 day
            if (nextPrayer.prayerName == "Fajr" && timeInMillis <= currentTime.timeInMillis) {
                add(Calendar.DAY_OF_MONTH, 1)
            }
        }

        val diffMillis = nextTime.timeInMillis - currentTime.timeInMillis

        val hours = TimeUnit.MILLISECONDS.toHours(diffMillis)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(diffMillis) % 60

        Log.d("HomeViewModel", "Remaining Time: ${hours}h ${minutes}m")

        return when {
            hours > 0 && minutes > 0 -> "بعد $hours ساعة و $minutes دقيقة"
            hours > 0 -> "بعد $hours ساعة"
            minutes > 0 -> "بعد $minutes دقيقة"
            else -> "الآن"
        }
    }


    fun Prayer.getTimeAsMinutes(): Int {
        val (h, m) = prayerTime.split(':').map { it.toInt() }
        return h * 60 + m
    }

    fun Prayer.mapNextPrayerName(): String {
        val name = this.prayerName
        return when {
            name == "Fajr" -> "الفجر"
            name == "Sunrise" -> "الشروق"
            name == "Dhuhr" -> "الظهر"
            name == "Asr" -> "العصر"
            name == "Sunset" -> "الغروب"
            name == "Maghrib" -> "المغرب"
            name == "Isha" -> "العشاء"
            name == "Imsak" -> "الامساك"
            name == "Firstthird" -> "الثلث الاول"
            name == "Midnight" -> "الثلث الثاني"
            name == "Lastthird" -> "التلث الاخير"
            else -> name
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getTheProgress(): Int {
        val currentTime = LocalTime.now().let { it.hour * 60 + it.minute }
        val nextPrayer = prayerTimes.value.first { it.getTimeAsMinutes() >= currentTime }
        val nextPrayerIndex = prayerTimes.value.indexOf(nextPrayer)
        val previousPrayerIndex = nextPrayerIndex - 1
        val nextPrayerTimeAsMinutes = nextPrayer.getTimeAsMinutes()

        if (previousPrayerIndex >= 0) {
            val previousPrayerTime = prayerTimes.value[previousPrayerIndex].getTimeAsMinutes()
            val totalTimeBetweenPrayers = nextPrayerTimeAsMinutes - previousPrayerTime

            val progress = (currentTime - previousPrayerTime) * 100 / totalTimeBetweenPrayers
            Log.d("HomeViewModel", "lastPrayerTime: $previousPrayerTime")
            Log.d("HomeViewModel", "currentTime: $currentTime")
            Log.d("HomeViewModel", "totalTimeBetweenPrayers: $totalTimeBetweenPrayers")
            Log.d("HomeViewModel", "previousPrayerIndex: $previousPrayerIndex")
            return progress
        } else {

            val progress = (currentTime) * 100 / nextPrayerTimeAsMinutes
            Log.d("HomeViewModel", "currentTime: $currentTime")
            Log.d("HomeViewModel", "nextPrayerTime: $nextPrayerTimeAsMinutes")
            Log.d("HomeViewModel", "progress: $progress")
            Log.d("HomeViewModel", "lastPrayerIndex: $previousPrayerIndex")

            return progress
        }
    }
}