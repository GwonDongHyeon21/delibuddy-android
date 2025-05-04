package com.example.delibuddy.navigation.chat

sealed class ChatNavigationItem(val destination: String) {
    data object ChatList : ChatNavigationItem("채팅")
    data object ChatRoom : ChatNavigationItem("채팅방")
}