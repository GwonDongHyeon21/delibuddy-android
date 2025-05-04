package com.example.delibuddy.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.delibuddy.ui.theme.MainBackground
import com.example.delibuddy.ui.theme.MainColor

@Composable
fun CenterCircularProgressIndicator() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MainBackground)
    ) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center),
            trackColor = MainColor.copy(alpha = 0.4f),
            color = MainColor
        )
    }
}