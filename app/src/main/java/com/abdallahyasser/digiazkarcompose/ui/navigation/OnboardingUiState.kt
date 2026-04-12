package com.abdallahyasser.digiazkarcompose.ui.navigation

data class OnboardingUiState(val page: Int = 0,val pageTitle: String,val pageDescription: String )

object OnboardingState{
    val page1= OnboardingUiState(1,"القرآن الكريم","اقرأ القرآن الكريم بخط واضح وتصميم جميل مع إمكانية الاستماع للتلاوات")
    val page2= OnboardingUiState(2,"مواقيت الصلاة","تنبيهات دقيقة لمواقيت الصلاة حسب موقعك مع صوت الأذان")
    val page3= OnboardingUiState(3,"رفيقك الروحاني","تذكيرات يومية، أذكار، تسبيح، وكل ما تحتاجه في رحلتك الإيمانية")
}