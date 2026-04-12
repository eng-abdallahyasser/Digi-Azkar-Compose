package com.abdallahyasser.digiazkarcompose.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abdallahyasser.digiazkarcompose.R
import com.abdallahyasser.digiazkarcompose.ui.theme.*

@Composable
fun OnboardingScreen(finishOnboarding: () -> Unit) {
    val viewModel = viewModel<OnboardingViewModel>()
    val uiState = viewModel.uiState.collectAsState()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        // Decorative circles
        // Large green circle top right
        Box(
            modifier = Modifier
                .size(444.86.dp)
                .offset(x = 175.57.dp, y = (-190.43).dp)
                .border(6.dp, PrimaryGreen.copy(alpha = 0.1f), CircleShape)
        )

        // Large gold circle bottom left
        Box(
            modifier = Modifier
                .size(444.86.dp)
                .offset(x = (-190.43).dp, y = 677.57.dp)
                .border(6.dp, PrimaryGold.copy(alpha = 0.1f), CircleShape)
        )

        // Medium green circle center
        Box(
            modifier = Modifier
                .size(384.dp)
                .offset(x = 23.dp, y = 274.dp)
                .border(4.dp, PrimaryGreen.copy(alpha = 0.1f), CircleShape)
        )

        // Content container
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            // Icon section
//            Box(
//                modifier = Modifier
//                    .size(112.dp)
//                    .align(Alignment.CenterHorizontally)
//            ) {
//                // Blur background
//                Box(
//                    modifier = Modifier
//                        .size(168.dp)
//                        .background(PrimaryGreen.copy(alpha = 0.3f))
//                        .blur(64.dp)
//                )
//
//                // Icon circle
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(
//                            brush = Brush.verticalGradient(
//                                colors = listOf(PrimaryGreen, PrimaryGreenDark)
//                            ),
//                            shape = RoundedCornerShape(24.dp)
//                        )
//                        .border(4.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(24.dp))
//                ) {
//                    // Placeholder for icon, assuming a vector drawable
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_quran), // Need to add this drawable
//                        contentDescription = "Quran Icon",
//                        modifier = Modifier
//                            .size(56.dp)
//                            .align(Alignment.Center),
//                        tint = Color.White
//                    )
//                }
//            }

            // Title
            Text(
                text = uiState.value.pageTitle,
                fontFamily = CairoFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 36.sp,
                lineHeight = 40.sp,
                textAlign = TextAlign.Center,
                color = TextDark,
            )

            // Gradient line
            Box(
                modifier = Modifier
                    .width(64.dp)
                    .height(4.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color.Transparent,
                                TextGray.copy(alpha = 0.3f),
                                Color.Transparent
                            )
                        ),
                        shape = RoundedCornerShape(50)
                    )
                    .align(Alignment.CenterHorizontally)
            )

            // Description
            Text(
                text = uiState.value.pageDescription,
                fontFamily = CairoFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                lineHeight = 29.sp,
                textAlign = TextAlign.Center,
                color = TextGray,
                modifier = Modifier.padding(vertical = 24.dp)

            )

            // Dots
            Row(
                modifier = Modifier
                    .padding(vertical = 24.dp)
                    .height(10.dp)
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                (1..3).forEach { pageNum ->
                    val isActive = pageNum == uiState.value.page
                    Box(
                        modifier = Modifier
                            .size(width = if (isActive) 40.dp else 10.dp, height = 10.dp)
                            .background(
                                brush = if (isActive && uiState.value.page != 2) {
                                    Brush.verticalGradient(
                                        colors = listOf(PrimaryGreen, PrimaryGreenDark)
                                    )
                                } else if (isActive && uiState.value.page == 2) {
                                    Brush.verticalGradient(
                                        colors = listOf(PrimaryGold, SecondaryGold)
                                    )
                                } else Brush.verticalGradient(
                                    colors = listOf(
                                        Color(0xFFE8E6E1),
                                        Color(0xFFE8E6E1)
                                    )
                                ),
                                shape = CircleShape
                            )
                    )
                }
            }
        }
        // Bottom bar
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(105.dp)
                .align(Alignment.BottomEnd)
                .background(Color.White.copy(alpha = 0.06f)) // Approximate

        ) {

            // Next button
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        if (uiState.value.page == 3) {
                            finishOnboarding()
                        } else {
                            viewModel.onNextClicked()
                        }
                    },
                    modifier = Modifier
                        .size(180.dp, 54.dp)
                        .padding(horizontal = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (uiState.value.page != 2) PrimaryGreen else PrimaryGold,

                        ),
                    shape = RoundedCornerShape(50)
                ) {

                    if (uiState.value.page == 3) {
                        Text(
                            text = "ابدأ الآن",
                            fontFamily = CairoFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            color = Color.White,

                            )
                    } else {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            // Icon
                            Icon(
                                painter = painterResource(id = R.drawable.left_arrow), // Need to add
                                contentDescription = "التالي",
                                modifier = Modifier.size(16.dp),
                                tint = Color.White
                            )
                            Text(
                                text = "التالي",
                                fontFamily = CairoFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                color = Color.White
                            )

                        }
                    }
                }


                if (uiState.value.page != 1) {
                    Box(
                        modifier = Modifier
                            .clickable {
                                viewModel.onBackClicked()
                            }
                            .size(54.dp)
                            .border(3.dp, PrimaryGreen.copy(alpha = 0.1f), CircleShape)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.right_arrow), // Need to add
                            contentDescription = "الرجوع",
                            modifier = Modifier
                                .size(16.dp)
                                .align(Alignment.Center),
                            tint = Color.Black,
                        )
                    }
                }

            }


            // Skip button
            TextButton(
                onClick = { viewModel.onSkipClicked() },
                modifier = Modifier
                    .size(90.dp, 48.dp)
            ) {
                Text(
                    text = "تخطي",
                    fontFamily = CairoFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = TextGray
                )
            }
        }
    }
}
