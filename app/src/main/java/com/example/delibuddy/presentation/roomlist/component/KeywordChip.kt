package com.example.delibuddy.presentation.roomlist.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.delibuddy.presentation.component.CustomText2

@Composable
fun KeywordChip(keyword: String, color: Color, onClick: () -> Unit) {
    Surface(
        color = color,
        modifier = Modifier
            .clip(RoundedCornerShape(97.dp))
            .clickable(
                onClick = { onClick() },
                interactionSource = null,
                indication = null
            )
    ) {
        Box(modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)) {
            CustomText2(keyword)
        }
    }
}