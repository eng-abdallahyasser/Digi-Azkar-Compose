package com.abdallahyasser.digiazkarcompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.abdallahyasser.digiazkarcompose.R

val CairoFamily = FontFamily(
    Font(R.font.cairo_regular, FontWeight.Normal),
    Font(R.font.cairo_medium, FontWeight.Medium),
    Font(R.font.cairo_semibold, FontWeight.SemiBold),
    Font(R.font.cairo_bold, FontWeight.Bold)
)

val AmiriFamily = FontFamily.Default

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = CairoFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 32.sp,
        lineHeight = 24.sp,
        textAlign = androidx.compose.ui.text.style.TextAlign.Right
    ),
    headlineMedium = TextStyle(
        fontFamily = CairoFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        textAlign = androidx.compose.ui.text.style.TextAlign.Right
    ),
    titleLarge = TextStyle(
        fontFamily = CairoFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        textAlign = androidx.compose.ui.text.style.TextAlign.Right
    ),
    bodyLarge = TextStyle(
        fontFamily = CairoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        textAlign = androidx.compose.ui.text.style.TextAlign.Right
    ),
    bodySmall = TextStyle(
        fontFamily = CairoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        textAlign = androidx.compose.ui.text.style.TextAlign.Right
    ),
    labelMedium = TextStyle(
        fontFamily = AmiriFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 48.sp,
        textAlign = androidx.compose.ui.text.style.TextAlign.Center
    )
)