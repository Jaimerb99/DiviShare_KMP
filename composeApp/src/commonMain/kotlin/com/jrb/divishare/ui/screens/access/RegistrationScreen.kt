package com.jrb.divishare.ui.screens.access

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
import com.jrb.divishare.ui.components.BackToolbar
import com.jrb.divishare.ui.components.DateBox
import com.jrb.divishare.ui.components.DateDialog
import com.jrb.divishare.ui.components.EmailTextField
import com.jrb.divishare.ui.components.NameTextField
import com.jrb.divishare.ui.components.PasswordTextField
import com.jrb.divishare.ui.components.PhoneTextField
import com.jrb.divishare.ui.components.TextButtonBox
import com.jrb.divishare.util.isValidEmail

class RegistrationScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val registerUser: () -> Unit = {}
        val onBack: () -> Unit = {navigator.pop()}
        RegistrationScreen(registerUser, onBack)
    }

}

@Composable
fun RegistrationScreen(
    registerUser: () -> Unit,
    onBack: () -> Unit
){
    var emailText by remember { mutableStateOf(TextFieldValue("")) }
    var nameText by remember { mutableStateOf(TextFieldValue("")) }
    var passwordText by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPasswordText by remember { mutableStateOf(TextFieldValue("")) }
    var prefix by remember { mutableStateOf(TextFieldValue( "")) }
    var number by remember { mutableStateOf(TextFieldValue("")) }
    val showDatePicker = remember { mutableStateOf(false) }
    val selectedDate = remember { mutableStateOf("") }


    val scrollState = rememberScrollState()

    val buttonEnabled = remember {
        derivedStateOf {
            passwordText.text.isNotEmpty()
                    && isValidEmail(emailText.text)
                    && passwordText.text == confirmPasswordText.text
                    && nameText.text.isNotEmpty()
        }
    }

    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }

    if (showDatePicker.value) { DateDialog(showDatePicker, selectedDate) }



    Scaffold(
        modifier = Modifier.background(color = AppTheme.colors.background)
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
            .padding(WindowInsets.systemBars.asPaddingValues()),
        topBar = {
            BackToolbar("Create Account"){onBack()}
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
                Spacer(modifier = Modifier.weight(0.3f))

                Text("Name", modifier = Modifier.padding(start = 5.dp))
                NameTextField(value = nameText, onValueChange = { nameText = it }, "Example Name")

                Spacer(modifier = Modifier.weight(0.1f))

                Text("Email", modifier = Modifier.padding(start = 5.dp))
                EmailTextField(value = emailText, onValueChange = { emailText = it })

                Spacer(modifier = Modifier.weight(0.1f))

                Text("Phone Number", modifier = Modifier.padding(start = 5.dp))
                PhoneTextField(prefix, number, {prefix = it}, {number = it})

                Spacer(modifier = Modifier.weight(0.1f))

                Text("Birth Day", modifier = Modifier.padding(start = 5.dp))
                DateBox(text = selectedDate, showDatePicker = showDatePicker)

                Spacer(modifier = Modifier.weight(0.1f))

                Text("Password", modifier = Modifier.padding(start = 5.dp))
                PasswordTextField(value = passwordText, onValueChange = { passwordText = it }, false)

                Spacer(modifier = Modifier.weight(0.1f))

                Text("Confirm Password", modifier = Modifier.padding(start = 5.dp))
                PasswordTextField(value = confirmPasswordText, onValueChange = { confirmPasswordText = it }, false)

                Spacer(modifier = Modifier.weight(0.8f))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        buildAnnotatedString {
                            append("By continuing, you agree to\n")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Terms of Use and Privacy Policy.")
                            }
                        },
                        style = MaterialTheme.typography.subtitle2,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                            .padding(horizontal = 50.dp)

                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    TextButtonBox(
                        modifier = Modifier
                            .width(180.dp)
                            .height(40.dp),
                        text = "Sign up",
                        buttonEnabled = buttonEnabled
                    ) {showDatePicker.value = true}

                }

                Spacer(modifier = Modifier.weight(1f))


            }
        }
    }
}


