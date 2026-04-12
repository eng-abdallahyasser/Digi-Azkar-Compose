package com.abdallahyasser.digiazkarcompose.ui.navigation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class OnboardingViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(OnboardingState.page1)
    val uiState = _uiState.asStateFlow()

    fun onNextClicked(){
        _uiState.value = when (_uiState.value.page) {
            1 -> OnboardingState.page2
            2 -> OnboardingState.page3
            else -> {
                _uiState.value
            }
        }
    }
    fun onSkipClicked(){
        _uiState.value = OnboardingState.page3
    }
    fun onBackClicked(){
        _uiState.value = when (_uiState.value.page) {
            2 -> OnboardingState.page1
            3 -> OnboardingState.page2
            else -> {
                _uiState.value
            }
        }
    }

}