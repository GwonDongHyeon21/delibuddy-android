package com.example.delibuddy

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.delibuddy.MainActivity.Companion.USER_ID
import com.example.delibuddy.MainActivity.Companion.USER_TOKEN
import com.example.delibuddy.navigation.BottomNavigationGraph
import com.example.delibuddy.navigation.sign.SignNavigationGraph

@Composable
fun DelibuddyApp() {
    val context = LocalContext.current

    if (getUserToken(context))
        BottomNavigationGraph()
    else
        SignNavigationGraph()
}

fun getUserToken(context: Context): Boolean {
    val sharedPreferences = context.getSharedPreferences("DelibuddyUserPrefs", Context.MODE_PRIVATE)
    val userToken = sharedPreferences.getString("delibuddyUserToken", null) ?: ""
    val userId = sharedPreferences.getString("delibuddyUserId", null) ?: ""

    return if (userToken.isNotEmpty() && userId.isNotEmpty()) {
        USER_TOKEN = userToken
        USER_ID = userId
        true
    } else {
        false
    }
}