package com.jrb.divishare.ui.screens.access

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.jrb.divishare.ui.AppTheme
import divishare_kmm.composeapp.generated.resources.Res
import divishare_kmm.composeapp.generated.resources.logo
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource

class SplashScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(Unit) {
            delay(2000)
            navigator.push(OnboardingScreen())
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.background(AppTheme.colors.primary).fillMaxSize()

        ) {
            Box(
                modifier = Modifier.padding(start = 80.dp, end = 70.dp),

                ){
                Image(
                    painter = painterResource(Res.drawable.logo),
                    contentDescription = "App Logo",
                    colorFilter = ColorFilter.tint(AppTheme.colors.onPrimary),
                    modifier = Modifier
                        .fillMaxWidth()
                    ,
                    contentScale = ContentScale.Fit,
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Text("DiviShare",
                color = AppTheme.colors.onPrimary,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h4
            )

        }
    }

}

