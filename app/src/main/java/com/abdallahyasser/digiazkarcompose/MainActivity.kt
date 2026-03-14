package com.abdallahyasser.digiazkarcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import com.abdallahyasser.digiazkarcompose.ui.HomeScreen
import com.abdallahyasser.digiazkarcompose.ui.theme.DigiAzkarComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigiAzkarComposeTheme {
                HomeScreen()
            }
        }
    }
}
