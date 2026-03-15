package com.abdallahyasser.digiazkarcompose.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abdallahyasser.digiazkarcompose.ui.theme.*


@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    val viewModel = viewModel<HomeViewModel>()

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = BackgroundColor
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 32.dp)
            ) {
                // Top Header + Prayer Card Section
                item {
                    HeaderSection()
                }

                // Feature Grid SECTION
                item {
                    FeatureGrid()
                }

                // Wide Cards Section
                item {
                    WideActionCards()
                }
            }
        }
    }
}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(460.dp) // Based on the 415px in CSS
    ) {
        // Decorative Green Background Gradient
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(PrimaryGreen, PrimaryGreen, PrimaryGreenDark)
                    ),
                    shape = RoundedCornerShape(bottomStart = 48.dp, bottomEnd = 48.dp)
                )
        )

        // Decorative Circles
        // Top-Left corner circle (Right side in RTL)
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(x = 60.dp, y = (-80).dp)
                .size(160.dp)
                .border(4.dp, Color.White.copy(alpha = 0.15f), CircleShape)
        )
        // Mid-Right circle (Left side in RTL)
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = (-64).dp, y = 40.dp)
                .size(128.dp)
                .border(4.dp, Color.White.copy(alpha = 0.15f), CircleShape)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 24.dp)
        ) {
            Spacer(Modifier.height(16.dp))
            // Top Bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "المصحف الشريف",
                        style = MaterialTheme.typography.displayLarge,
                        color = Color.White
                    )
                    Text(
                        text = "السلام عليكم ورحمة الله",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                }
                
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    IconButton(
                        onClick = { },
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color.White.copy(alpha = 0.1f), CircleShape)
                    ) {
                        Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.White)
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    IconButton(
                        onClick = { },
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color.White.copy(alpha = 0.1f), CircleShape)
                    ) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notifications", tint = Color.White)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Main Prayer Card
            PrayerMainCard()
        }
    }
}

@Composable
fun PrayerMainCard() {
    val viewModel = viewModel<HomeViewModel>()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceWhite),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        if(viewModel.prayerTimes.value.isEmpty()){
            CircularProgressIndicator()
        }
        else{
            Column(
                modifier = Modifier
                    .padding(20.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = viewModel.getNextPrayer().prayerTime,
                            style = MaterialTheme.typography.displayLarge,
                            color = PrimaryGreen
                        )
                        Text(
                            text = viewModel.getRemainingTimeToNextPrayer(),
                            style = MaterialTheme.typography.bodySmall,
                            color = TextGray
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(horizontalAlignment = Alignment.End) {
                            Text(
                                text = "الصلاة القادمة",
                                style = MaterialTheme.typography.bodySmall,
                                color = TextGray
                            )
                            Text(
                                text = viewModel.getNextPrayer().prayerName,
                                style = MaterialTheme.typography.headlineMedium,
                                color = TextDark
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .background(
                                    Brush.verticalGradient(listOf(PrimaryGreen, PrimaryGreenDark)),
                                    CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.Star, contentDescription = null, tint = Color.White)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Progress Bar
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFE8E6E1))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(viewModel.getTheProgress()/100f)
                            .fillMaxHeight()
                            .background(PrimaryGreen)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Row of prayer times
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    PrayerTimeSmall("الفجر", viewModel.getPrayerTime("Fajr"), "🌅", Color(0xFFF3F4F6))
                    PrayerTimeSmall("الشروق", viewModel.getPrayerTime("Sunrise"), "☀️", Color(0xFFFEF3C6))
                    PrayerTimeSmall("الظهر", viewModel.getPrayerTime("Dhuhr"), "☀️", Color(0xFFFFF7ED), isActive = true)
                    PrayerTimeSmall("العصر", viewModel.getPrayerTime("Asr"), "🌤️", Color(0xFFFFF7ED))
                    PrayerTimeSmall("المغرب", viewModel.getPrayerTime("Maghrib"), "🌆", Color(0xFFFEF2F2))
                    PrayerTimeSmall("العشاء", viewModel.getPrayerTime("Isha"), "🌙", Color(0xFFEEF2FF))
                }
            }
        }
    }
}

@Composable
fun PrayerTimeSmall(name: String, time: String, icon: String, iconBg: Color, isActive: Boolean = false) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(iconBg, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(text = icon, fontSize = 12.sp)
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = name, style = MaterialTheme.typography.bodySmall, color = if(isActive) PrimaryGreen else TextGray)
        Text(text = time, style = MaterialTheme.typography.bodySmall, color = TextDark, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun FeatureGrid() {
    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
        // Ayah of the Day
        AyahCard()

        Spacer(modifier = Modifier.height(20.dp))

        // Grid of 6 features
        val features = listOf(
            FeatureData("المصحف", "قراءة القرآن الكريم", Icons.Default.Notifications, PrimaryGreen),
            FeatureData("الأذان", "مواقيت الصلاة", Icons.Default.Notifications, PrimaryGold),
            FeatureData("الأدعية والأذكار", "حصن المسلم", Icons.Default.Favorite, PrimaryGreen),
            FeatureData("التذكيرات", "تنبيهات يومية", Icons.Default.Star, PrimaryGold),
            FeatureData("تعليم القرآن", "دروس وتلاوات", Icons.Default.Place, PrimaryGreen),
            FeatureData("المساجد", "أقرب المساجد", Icons.Default.Place, PrimaryGold)
        )

        // Using standard Rows since LazyVerticalGrid inside LazyColumn is tricky without fixed height
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            for (i in 0 until 3) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    FeatureCard(features[i * 2], modifier = Modifier.weight(1f))
                    FeatureCard(features[i * 2 + 1], modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun AyahCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(2.dp, PrimaryGold),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Brush.verticalGradient(listOf(CardBeigeLight, CardBeigeDark)))
                .padding(26.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(PrimaryGold, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.Place, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "آية اليوم",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextGray,
                    letterSpacing = 1.sp
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                HorizontalDivider(modifier = Modifier.width(64.dp), color = PrimaryGold)
                
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "﴿ وَقُل رَّبِّ زِدۡنِی عِلۡمًا ﴾",
                    style = MaterialTheme.typography.labelMedium,
                    color = TextDark
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(modifier = Modifier.width(64.dp), color = PrimaryGold)
                
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "سورة طه - آية 114",
                    style = MaterialTheme.typography.bodyLarge,
                    color = TextGray,
                    fontSize = 14.sp
                )
            }
        }
    }
}

data class FeatureData(val title: String, val subtitle: String, val icon: ImageVector, val color: Color)

@Composable
fun FeatureCard(data: FeatureData, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .height(162.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.8f)),
        border = BorderStroke(1.dp, PrimaryGreen.copy(alpha = 0.06f))
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(
                        Brush.verticalGradient(
                            if (data.color == PrimaryGreen) listOf(PrimaryGreen, PrimaryGreenDark)
                            else listOf(PrimaryGold, SecondaryGold)
                        ),
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(data.icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(28.dp))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = data.title,
                style = MaterialTheme.typography.titleLarge,
                color = TextDark,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = data.subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = TextGray,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun WideActionCards() {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        WideCard("المسبحة", "عداد التسبيح", Icons.Default.Star, PrimaryGreen)
        WideCard("اتجاه القبلة", "تحديد اتجاه القبلة", Icons.Default.Star, PrimaryGold)
    }
}

@Composable
fun WideCard(title: String, subtitle: String, icon: ImageVector, color: Color) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(98.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.8f)),
        border = BorderStroke(1.dp, PrimaryGreen.copy(alpha = 0.06f))
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.End) {
                Text(text = title, style = MaterialTheme.typography.titleLarge, color = TextDark)
                Text(text = subtitle, style = MaterialTheme.typography.bodySmall, color = TextGray)
            }
            
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(
                        Brush.verticalGradient(
                            if (color == PrimaryGreen) listOf(PrimaryGreen, PrimaryGreenDark)
                            else listOf(PrimaryGold, SecondaryGold)
                        ),
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(28.dp))
            }
        }
    }
}
