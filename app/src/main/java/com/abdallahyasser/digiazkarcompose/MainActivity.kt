package com.abdallahyasser.digiazkarcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abdallahyasser.digiazkarcompose.ui.navigation.HomeRoute
import com.abdallahyasser.digiazkarcompose.ui.home.HomeScreen
import com.abdallahyasser.digiazkarcompose.ui.navigation.SplashRoute
import com.abdallahyasser.digiazkarcompose.ui.navigation.SplashScreen
import com.abdallahyasser.digiazkarcompose.ui.navigation.OnboardingRoute
import com.abdallahyasser.digiazkarcompose.ui.navigation.OnboardingScreen
import com.abdallahyasser.digiazkarcompose.ui.theme.DigiAzkarComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigiAzkarComposeTheme {
                val navController = rememberNavController()
                NavHost(
                    startDestination = SplashRoute,
                    navController = navController,
                ){
                    composable<HomeRoute>{
                        HomeScreen()
                    }
                    composable<SplashRoute>{
                        SplashScreen(navController)
                    }
                    composable<OnboardingRoute>{
                        OnboardingScreen{
                            navController.navigate(HomeRoute){
                                popUpTo(OnboardingRoute) { inclusive = true }
                            }
                        }
                    }
                }

            }
        }
    }
}
