package com.jrb.divishare

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.jrb.divishare.ui.screens.access.SplashScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme() {
        Navigator(SplashScreen()){
            SlideTransition(it)
        }
    }
}