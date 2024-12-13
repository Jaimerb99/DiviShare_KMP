package com.jrb.divishare

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.jrb.divishare.ui.components.ToolBar
import com.jrb.divishare.ui.screens.access.OnboardingScreen
import com.jrb.divishare.ui.screens.access.SplashScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme() {
        //ToolBar({}, {})
        //SplashScreen()
        OnboardingScreen {  }
    }
}