package com.example.delibuddy.network.model

import com.example.delibuddy.presentation.chatroom.model.ChatHistoryDetail
import com.google.gson.annotations.SerializedName

data class ChatHistoryResponse(
    @SerializedName("message") val message: String,
    @SerializedName("chats") val chatHistory: List<ChatHistoryDetail>
)