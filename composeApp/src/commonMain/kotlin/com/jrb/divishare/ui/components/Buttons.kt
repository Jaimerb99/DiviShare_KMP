package com.jrb.divishare.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jrb.divishare.ui.AppTheme

@Composable
fun TextButton(modifier: Modifier, text: String, onClick: () -> Unit){
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = AppTheme.colors.primary, contentColor = AppTheme.colors.onPrimary)

    ){
        Text(
            text,
            style = MaterialTheme.typography.button.copy(
                fontWeight = FontWeight.Bold
            ),
            fontSize = 15.sp,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@Composable
fun TextButtonBox(
    modifier: Modifier = Modifier,
    text: String,
    buttonEnabled: State<Boolean> = androidx.compose.runtime.mutableStateOf(true),
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable(enabled = buttonEnabled.value, onClick = if (buttonEnabled.value) onClick else {{}})
            .background(if(buttonEnabled.value) AppTheme.colors.primary else AppTheme.colors.placeholder, shape = RoundedCornerShape(12.dp))
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.button.copy(fontWeight = FontWeight.Bold),
            fontSize = 15.sp,
            color = AppTheme.colors.onPrimary
        )
    }
}
