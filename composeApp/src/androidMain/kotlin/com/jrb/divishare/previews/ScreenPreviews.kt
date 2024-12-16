package com.jrb.divishare.previews

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jrb.divishare.ui.screens.access.ForgotPasswordScreen
import com.jrb.divishare.ui.screens.access.LoginScreen
import com.jrb.divishare.ui.screens.access.OnboardingScreen
import com.jrb.divishare.ui.screens.access.RegistrationScreen

@Composable
@Preview
fun OnBoardingPreview(){
    MaterialTheme{
        OnboardingScreen{}
    }
}


@Composable
@Preview
fun LoginScreenPreview(){
    MaterialTheme{
        LoginScreen({},{},{})
    }
}

@Composable
@Preview
fun RegisterScreenPreview(){
    MaterialTheme{
        RegistrationScreen({},{})
    }
}

@Composable
@Preview
fun ForgotPasswordScreenPreview(){
    MaterialTheme{
        ForgotPasswordScreen({},{})
    }
}