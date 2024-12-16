package com.jrb.divishare.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jrb.divishare.ui.AppTheme
import com.jrb.divishare.util.parseDate
import network.chaintech.kmp_date_time_picker.ui.datepicker.WheelDatePickerView
import network.chaintech.kmp_date_time_picker.utils.DateTimePickerView
import network.chaintech.kmp_date_time_picker.utils.WheelPickerDefaults

@Composable
fun DateDialog(showDatePicker: MutableState<Boolean>, selectedDate: MutableState<String>) {
    WheelDatePickerView(
        title = "Birth Day",
        doneLabel = "OK",
        modifier = Modifier.padding(top = 18.dp, bottom = 10.dp).fillMaxWidth(),
        showDatePicker = showDatePicker.value,
        titleStyle = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = AppTheme.colors.primary,
        ),
        doneLabelStyle = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight(600),
            color = AppTheme.colors.primary,
        ),
        selectorProperties = WheelPickerDefaults.selectorProperties(
            borderColor = Color.Transparent,
        ),
        dateTextColor = AppTheme.colors.primary,
        rowCount = 5,
        height = 170.dp,
        dateTextStyle = TextStyle(
            fontWeight = FontWeight(600),
        ),
        onDoneClick = {
            selectedDate.value = parseDate(it.toString())
            showDatePicker.value = false
        },
        dateTimePickerView = DateTimePickerView.DIALOG_VIEW,
        onDismiss = {
            showDatePicker.value = false
        }
    )
}