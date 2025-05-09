package com.example.delibuddy.presentation.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.delibuddy.ui.theme.Brown2

@Composable
fun CustomText(text: String, alpha: Float = 1f) {
    Text(
        text = text,
        style = TextStyle(
            color = Brown2.copy(alpha = alpha),
            fontSize = 13.sp
        )
    )
}

@Composable
fun CustomText2(text: String, color: Color = Brown2, alpha: Float = 1f) {
    Text(
        text = text,
        style = TextStyle(
            color = color.copy(alpha = alpha),
            fontSize = 12.sp
        )
    )
}

@Composable
fun CustomText3(text: String, alpha: Float = 1f) {
    Text(
        text = text,
        style = TextStyle(
            color = Brown2.copy(alpha = alpha),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun CustomText4(text: String, alpha: Float = 1f) {
    Text(
        text = text,
        style = TextStyle(
            color = Brown2.copy(alpha = alpha),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun CustomText5(text: String, alpha: Float = 1f) {
    Text(
        text = text,
        style = TextStyle(
            color = Brown2.copy(alpha = alpha),
            fontSize = 15.sp,
        )
    )
}

@Composable
fun CustomText6(text: String, alpha: Float = 1f) {
    Text(
        text = text,
        style = TextStyle(
            color = Brown2.copy(alpha = alpha),
            fontSize = 18.sp,
        )
    )
}

@Composable
fun CustomText7(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            color = color,
            fontSize = 12.sp,
        )
    )
}