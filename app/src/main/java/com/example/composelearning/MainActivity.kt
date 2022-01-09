package com.example.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composelearning.ui.HomeScreen
import com.example.composelearning.ui.theme.MeditationUIYouTubeTheme


class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MeditationUIYouTubeTheme {
                HomeScreen()
            }
        }
    }
}