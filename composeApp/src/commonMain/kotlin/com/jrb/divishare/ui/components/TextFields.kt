package com.jrb.divishare.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.jrb.divishare.ui.AppTheme
import com.jrb.divishare.util.isValidEmail
import divishare_kmm.composeapp.generated.resources.Res
import divishare_kmm.composeapp.generated.resources.ic_closed_eye
import divishare_kmm.composeapp.generated.resources.ic_open_eye
import org.jetbrains.compose.resources.vectorResource

@Composable
fun EmailBox(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
){
    val focusManager = LocalFocusManager.current
    val emailBorder = if(value.text.isNotEmpty() && !isValidEmail(value.text)) Color.Red else Color.Transparent
    TextField(
        singleLine = true,
        value = value,
        /*label = { Text("Email") },*/
        onValueChange = onValueChange,
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = AppTheme.colors.primaryVariant,
            textColor = AppTheme.colors.onPrimary,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            placeholderColor = AppTheme.colors.onPrimary.copy(alpha = 0.6f)
        ),
        placeholder = {Text("your@email.com")},
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            /*.padding(start = 5.dp)*/
            .border(
                BorderStroke(1.dp, emailBorder),
                RoundedCornerShape(10.dp)
            ),
        keyboardOptions = KeyboardOptions.Default.copy(
            capitalization = KeyboardCapitalization.None
        ),
        keyboardActions = KeyboardActions(
            onDone = { focusManager.clearFocus() }
        )
    )
}

@Composable
fun PasswordBox(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    error: Boolean,
){
    var passwordVisibility: Boolean by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val borderError = if (value.text.isNotEmpty() && error) Color.Red else Color.Transparent

    Column {
        TextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            shape = RoundedCornerShape(10.dp),
            trailingIcon = {
                Icon(
                    modifier = Modifier.clip(RoundedCornerShape(10.dp)).clickable {
                        passwordVisibility = !passwordVisibility
                    },
                    imageVector =  if (passwordVisibility) vectorResource(Res.drawable.ic_open_eye)
                        else vectorResource(Res.drawable.ic_closed_eye)
                    ,
                    contentDescription = null
                )
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            placeholder = { Text("************") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = AppTheme.colors.primaryVariant,
                textColor = AppTheme.colors.onPrimary,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                placeholderColor = AppTheme.colors.onPrimary.copy(alpha = 0.6f),
                trailingIconColor = AppTheme.colors.onPrimary
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                /*.padding(start = 5.dp)*/
                .border(
                    BorderStroke(1.dp, borderError),
                    RoundedCornerShape(10.dp)
                ),
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.None,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.None
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            )
        )
        /*Text(
            modifier = Modifier
                .width(330.dp)
                .padding(start = 5.dp, top = 10.dp),
            text = if (error)stringResource(id = R.string.login_error) else "",
            color = MaterialTheme.colorScheme.error,
            fontSize = 14.sp,
            fontWeight = FontWeight.W500
        )*/
    }
}


