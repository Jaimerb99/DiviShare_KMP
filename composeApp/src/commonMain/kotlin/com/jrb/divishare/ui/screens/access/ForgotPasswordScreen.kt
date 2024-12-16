package com.jrb.divishare.ui.screens.access


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.jrb.divishare.ui.AppTheme
import com.jrb.divishare.ui.components.BackToolbar
import com.jrb.divishare.ui.components.EmailTextField
import com.jrb.divishare.ui.components.TextButtonBox
import divishare_kmm.composeapp.generated.resources.Res
import divishare_kmm.composeapp.generated.resources.ic_empty_inbox
import divishare_kmm.composeapp.generated.resources.logini_image
import divishare_kmm.composeapp.generated.resources.no_results_image
import org.jetbrains.compose.resources.painterResource

class ForgotPasswordScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val onSendRecoveryEmail: () -> Unit = {}
        val onBack: () -> Unit = {navigator.pop()}
        ForgotPasswordScreen(onSendRecoveryEmail, onBack)
    }
}

@Composable
fun ForgotPasswordScreen(
    onSendRecoveryEmail: () -> Unit,
    onBack: () -> Unit,
){
    var emailText by remember { mutableStateOf(TextFieldValue("")) }
    val focusManager = LocalFocusManager.current

    Scaffold(
        modifier = Modifier.background(color = AppTheme.colors.background)
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
        /*.padding(WindowInsets.systemBars.asPaddingValues())*/
        ,
        topBar = {
            Box (modifier = Modifier.padding(top = 30.dp)){ BackToolbar("Forgot Password"){ onBack() } }

        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            Column(
                Modifier.fillMaxWidth().padding(horizontal = 20.dp).padding(top = 30.dp).weight(2f)
            ) {
                Text(
                    "Reset Password?",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    "Please enter your email address, and we will send you an email with instructions to reset your password.",
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.subtitle1.fontSize,
                        lineHeight = 16.sp
                    )
                )
            }

            Column(
                Modifier
                    .fillMaxWidth()
                    .weight(8f)
                    .clip(RoundedCornerShape(topStart = 31.dp, topEnd = 31.dp))
                    .background(AppTheme.colors.primaryVariant)
                    .padding(20.dp)
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    "Enter your email address",
                    modifier = Modifier
                        .padding(start = 5.dp, bottom = 5.dp),
                    style = TextStyle(color = AppTheme.colors.onSecondary, fontSize = 18.sp)
                )
                EmailTextField(value = emailText, onValueChange = { emailText = it }, inverted = true)
                Spacer(modifier = Modifier.height(30.dp))
                TextButtonBox(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(180.dp)
                        .height(40.dp),
                    text = "Recover",
                ) {  }
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(resource = Res.drawable.ic_empty_inbox),
                    contentDescription = "Onboarding Image",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}