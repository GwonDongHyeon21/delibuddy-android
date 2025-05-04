package com.example.delibuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {

    companion object {
        lateinit var USER_TOKEN: String
        lateinit var USER_ID: String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DelibuddyApp()
        }
    }
}