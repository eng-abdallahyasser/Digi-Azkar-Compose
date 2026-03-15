package com.abdallahyasser.digiazkarcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abdallahyasser.digiazkarcompose.ui.HomeRoute
import com.abdallahyasser.digiazkarcompose.ui.HomeScreen
import com.abdallahyasser.digiazkarcompose.ui.SplashRoute
import com.abdallahyasser.digiazkarcompose.ui.SplashScreen
import com.abdallahyasser.digiazkarcompose.ui.theme.DigiAzkarComposeTheme

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
                        SplashScreen()
                    }
                }

            }
        }
    }
}
