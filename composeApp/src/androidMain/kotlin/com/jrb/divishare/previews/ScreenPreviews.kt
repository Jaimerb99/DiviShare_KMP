package com.jrb.divishare.previews

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jrb.divishare.ui.screens.access.LoginScreen
import com.jrb.divishare.ui.screens.access.OnboardingScreen

@Composable
@Preview
fun OnBoardingPreview(){
    MaterialTheme{
        OnboardingScreen(
            onNavigateToLogin = {}
        )
    }
}


@Composable
@Preview
fun LoginScreenPreview(){
    MaterialTheme{
        LoginScreen()
    }
}