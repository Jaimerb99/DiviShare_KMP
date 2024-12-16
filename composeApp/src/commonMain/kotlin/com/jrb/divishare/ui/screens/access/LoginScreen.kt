package com.jrb.divishare.ui.screens.access

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.jrb.divishare.ui.AppTheme
import com.jrb.divishare.ui.components.EmailTextField
import com.jrb.divishare.ui.components.LoginToolbar
import com.jrb.divishare.ui.components.PasswordTextField
import com.jrb.divishare.ui.components.TextButtonBox
import com.jrb.divishare.util.isValidEmail
import divishare_kmm.composeapp.generated.resources.Res
import divishare_kmm.composeapp.generated.resources.logini_image
import org.jetbrains.compose.resources.painterResource

class LoginScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val onNavigateToForgotPassword: () -> Unit = {navigator.push(ForgotPasswordScreen())}
        val onNavigateToRegister: () -> Unit = {navigator.push(RegistrationScreen())}
        val onNavigateToMainScreen: () -> Unit = {navigator.push(OnboardingScreen())}
        LoginScreen(onNavigateToForgotPassword,onNavigateToMainScreen, onNavigateToRegister)
    }

}

@Composable
fun LoginScreen(
    onNavigateToForgotPassword: () -> Unit,
    onNavigateToMainScreen: () -> Unit,
    onNavigateToRegister: () -> Unit,
){
    var emailText by remember { mutableStateOf(TextFieldValue("")) }
    var passwordText by remember { mutableStateOf(TextFieldValue("")) }

    val scrollState = rememberScrollState()

    val buttonEnabled = remember {
        derivedStateOf {
            passwordText.text.isNotEmpty() && isValidEmail(emailText.text)
        }
    }

    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }


    Scaffold(
        modifier = Modifier.background(color = AppTheme.colors.background)
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
            .padding(WindowInsets.systemBars.asPaddingValues()),
        topBar = {
            LoginToolbar()
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {
                Spacer(modifier = Modifier.weight(0.1f))
                Text(
                    "Welcome Aboard!",
                    style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Image(
                    painter = painterResource(resource = Res.drawable.logini_image),
                    contentDescription = "Onboarding Image",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )

                Text("Email", modifier = Modifier.padding(start = 5.dp))
                EmailTextField(value = emailText, onValueChange = { emailText = it })

                Spacer(modifier = Modifier.weight(0.1f))

                Text("Password", modifier = Modifier.padding(start = 5.dp))
                PasswordTextField(value = passwordText, onValueChange = { passwordText = it }, false)

                Spacer(modifier = Modifier.weight(0.3f))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextButtonBox(
                        modifier = Modifier
                            .width(180.dp)
                            .height(40.dp),
                        text = "Log In",
                        buttonEnabled = buttonEnabled
                    ) { onNavigateToMainScreen() }
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(
                        "Forgot Password?",
                        style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(start = 5.dp)
                            .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) { onNavigateToForgotPassword() }
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    buildAnnotatedString {
                        append("Don’t have an account? ")
                        withStyle(style = SpanStyle(AppTheme.colors.primary)) {
                            append("Sign Up")
                        }
                    },
                    style = MaterialTheme.typography.subtitle1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) { onNavigateToRegister()}
                )
            }
        }
    }
}