package com.example.delibuddy.network.model

import com.google.gson.annotations.SerializedName

data class SendMessageResponse(
    @SerializedName("message") val responseMessage: String,
    @SerializedName("chatId") val chatId: String
)