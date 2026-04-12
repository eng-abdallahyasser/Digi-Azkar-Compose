package com.abdallahyasser.digiazkarcompose.ui.navigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdallahyasser.digiazkarcompose.ui.theme.CairoFamily
import com.abdallahyasser.digiazkarcompose.ui.theme.PrimaryGold
import com.abdallahyasser.digiazkarcompose.ui.theme.PrimaryGreen
import com.abdallahyasser.digiazkarcompose.ui.theme.PrimaryGreenDark


@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(1000) // 2 seconds delay
        navController.navigate(OnboardingRoute) {
            popUpTo(SplashRoute) { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        PrimaryGreen,
                        PrimaryGreen,
                        PrimaryGreenDark
                    )
                )
            )
    ) {
        // Decorative Circles
        DecorativeCircle(
            size = 128.dp,
            border = 4.dp,
            offsetX = 40.dp,
            offsetY = 80.dp
        )
        DecorativeCircle(
            size = 160.dp,
            border = 4.dp,
            offsetX = 230.dp,
            offsetY = 692.dp
        )
        DecorativeCircle(
            size = 256.dp,
            border = 2.dp,
            offsetX = 87.dp,
            offsetY = 338.dp
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
//            // Icon Container with Corners
//            Box(
//                modifier = Modifier
//                    .size(96.dp)
//                    .background(Color.White.copy(alpha = 0.0f), shape = RoundedCornerShape(24.dp))
//                    .border(2.dp, PrimaryGold, RoundedCornerShape(24.dp))
//            ) {
//                // Gold Corners
//                GoldCorner(0f, 0f, CornerType.TopLeft)
//                GoldCorner(84f, 0f, CornerType.TopRight)
//                GoldCorner(0f, 84f, CornerType.BottomLeft)
//                GoldCorner(84f, 84f, CornerType.BottomRight)
//                // Icon
//                Image(
//                    painter = painterResource(R.drawable.islamic_icon),
//                    contentDescription = "null",
//                    modifier = Modifier
//                        .size(72.dp)
//                        .align(Alignment.Center)
//                )
//            }
            Spacer(modifier = Modifier.height(40.dp))
            // Title
            Text(
                text = "المصحف الشريف",
                fontFamily = CairoFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 36.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                letterSpacing = 0.9.sp,
                modifier = Modifier
                    .width(266.dp)
            )
            // Separator
            Box(
                modifier = Modifier
                    .width(80.dp)
                    .height(1.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                PrimaryGold,
                                Color.Transparent
                            )
                        )
                    )
            )
            // Verse
            Text(
                text = "﴾ وَرَتِّلِ الْقُرْآنَ تَرْتِيلًا ﴿",
                fontFamily = FontFamily.Serif, // Replace with AmiriFamily if available
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                color = PrimaryGold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(vertical = 16.dp)
            )
            // Verse Reference
            Text(
                text = "سورة المزمل - آية 4",
                fontFamily = CairoFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.6f),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom =  16.dp)
            )
            // Dots
            Row{
                Dot(8.dp, 0.6f)
                Spacer(modifier = Modifier.width(8.dp))
                Dot(8.dp, 0.6f)
                Spacer(modifier = Modifier.width(8.dp))
                Dot(8.dp, 0.6f)
            }
        }
    }
}

@Composable
fun DecorativeCircle(size: Dp, border: Dp, offsetX: Dp, offsetY: Dp) {
    Box(
        modifier = Modifier
            .size(size)
            .offset(offsetX, offsetY)
            .border(border, PrimaryGold.copy(alpha = 0.15f), CircleShape)

    )
}

enum class CornerType { TopLeft, TopRight, BottomLeft, BottomRight }

@Composable
fun GoldCorner(x: Float, y: Float, type: CornerType) {
    Box(
        modifier = Modifier
            .absoluteOffset(x.dp, y.dp)
            .size(12.dp)
            .then(
                when (type) {
                    CornerType.TopLeft -> Modifier
                        .border(
                            border = BorderStroke(2.dp, PrimaryGold),
                            shape = RoundedCornerShape(topStart = 0.dp)
                        )
                        .border(
                            border = BorderStroke(
                                0.dp,
                                Color.Transparent
                            ),
                            shape = RoundedCornerShape(
                                topEnd = 0.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 0.dp
                            )
                        )

                    CornerType.TopRight -> Modifier.border(
                        border = BorderStroke(2.dp, PrimaryGold),
                        shape = RoundedCornerShape(topEnd = 0.dp)
                    )

                    CornerType.BottomLeft -> Modifier.border(
                        border = BorderStroke(2.dp, PrimaryGold),
                        shape = RoundedCornerShape(bottomStart = 0.dp)
                    )

                    CornerType.BottomRight -> Modifier.border(
                        border = BorderStroke(2.dp, PrimaryGold),
                        shape = RoundedCornerShape(bottomEnd = 0.dp)
                    )
                }
            )
    )
}

@Composable
fun Dot(size: Dp, opacity: Float) {
    Box(
        modifier = Modifier
            .size(size)
            .background(PrimaryGold.copy(alpha = opacity), CircleShape)
    )
}
