package com.jrb.divishare.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jrb.divishare.ui.AppTheme
import com.jrb.divishare.util.isValidEmail
import divishare_kmm.composeapp.generated.resources.Res
import divishare_kmm.composeapp.generated.resources.ic_closed_eye
import divishare_kmm.composeapp.generated.resources.ic_open_eye
import org.jetbrains.compose.resources.vectorResource

@Composable
fun EmailTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    inverted: Boolean = false
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
            backgroundColor = if (inverted) AppTheme.colors.background else AppTheme.colors.primaryVariant,
            textColor = if (inverted) AppTheme.colors.primaryVariant else AppTheme.colors.onPrimary,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            placeholderColor = if (inverted) AppTheme.colors.primary else AppTheme.colors.onPrimary.copy(alpha = 0.6f)
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
fun PasswordTextField(
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

@Composable
fun NameTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    placeholder: String
){
    val focusManager = LocalFocusManager.current
    TextField(
        singleLine = true,
        value = value,
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
        placeholder = {Text(placeholder)},
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp),
        keyboardOptions = KeyboardOptions.Default.copy(
            capitalization = KeyboardCapitalization.None
        ),
        keyboardActions = KeyboardActions(
            onDone = { focusManager.clearFocus() }
        )
    )
}

@Composable
fun PhoneTextField(
    prefixValue: TextFieldValue,
    phoneValue: TextFieldValue,
    onPrefixChange: (TextFieldValue) -> Unit,
    onPhoneNumberChange: (TextFieldValue) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    val formattedPhoneNumber = phoneValue.text
        .filter { it.isDigit() }
        .chunked(3)
        .joinToString(" ")

    LaunchedEffect(phoneValue.text) {
        onPhoneNumberChange(TextFieldValue(formattedPhoneNumber))
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .border(BorderStroke(1.dp, Color.Transparent), RoundedCornerShape(10.dp))
    ) {
        TextField(
            value = prefixValue,
            onValueChange = { newPrefix ->
                val text = newPrefix.text
                when {
                    !text.startsWith("+") -> {
                        val filteredDigits = text.filter { it.isDigit() }
                        if(filteredDigits != ""){
                            val updatedText = "+$filteredDigits"
                            onPrefixChange(TextFieldValue(updatedText, TextRange(updatedText.length)))
                        }
                    }
                    text == "+" -> {
                        onPrefixChange(TextFieldValue(""))
                    }
                    text.startsWith("+") && text.length <= 3 -> {
                        val filteredDigits = text.substring(1).filter { it.isDigit() }
                        val updatedText = "+$filteredDigits"
                        onPrefixChange(TextFieldValue(updatedText, TextRange(updatedText.length)))
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = AppTheme.colors.primaryVariant,
                textColor = AppTheme.colors.onPrimary,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                placeholderColor = AppTheme.colors.onPrimary.copy(alpha = 0.6f)
            ),
            placeholder = { Text("+34") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                capitalization = KeyboardCapitalization.None
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            modifier = Modifier
                .width(70.dp)
                .height(52.dp)
        )


        TextField(

            value = TextFieldValue(formattedPhoneNumber, TextRange(formattedPhoneNumber.length)),
            onValueChange = { newPhoneNumber ->
                if (newPhoneNumber.text.length < 12) {
                    onPhoneNumberChange(newPhoneNumber)
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = AppTheme.colors.primaryVariant,
                textColor = AppTheme.colors.onPrimary,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                placeholderColor = AppTheme.colors.onPrimary.copy(alpha = 0.6f)
            ),
            placeholder = { Text("123 456 789") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                capitalization = KeyboardCapitalization.None
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
                .height(52.dp)
        )
    }
}

@Composable
fun DateTextField(
    value: MutableState<String>,
    showDatePicker: MutableState<Boolean>
) {
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }

    TextField(
        singleLine = true,
        value = value.value, // Display the selected date or empty string
        onValueChange = { }, // Prevent manual changes, handle date through the picker
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = AppTheme.colors.primaryVariant,
            textColor = AppTheme.colors.onPrimary,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            placeholderColor = AppTheme.colors.onPrimary.copy(alpha = 0.6f)
        ),
        placeholder = { Text("Select date") },
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(focusRequester)
            .clickable {
                focusManager.clearFocus()
                showDatePicker.value = true
            }
            .height(52.dp)
            ,
        keyboardOptions = KeyboardOptions.Default.copy(
            capitalization = KeyboardCapitalization.None
        ),
        keyboardActions = KeyboardActions(
            onDone = { focusManager.clearFocus() }
        )
    )
}

@Composable
fun DateBox(
    text: MutableState<String>,
    showDatePicker: MutableState<Boolean>
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = AppTheme.colors.primaryVariant,
                shape = RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
            .height(52.dp)
            .padding(start = 16.dp, end = 16.dp) // Add padding for better text alignment
            .clickable {
                // When clicked, trigger the date picker by updating the showDatePicker state
                showDatePicker.value = true
            }

    ) {
        val emptyDate = text.value.isEmpty()
        Text(
            text = text.value.ifEmpty { "Select date" },
            style = TextStyle(
                color = if(emptyDate) AppTheme.colors.onPrimary.copy(alpha = 0.6f) else AppTheme.colors.onPrimary,
                fontSize = 16.sp
            ),
            modifier = Modifier.align(Alignment.CenterStart)
        )
    }
}


