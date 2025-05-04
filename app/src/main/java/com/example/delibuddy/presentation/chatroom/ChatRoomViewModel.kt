package com.example.delibuddy.presentation.chatroom

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.delibuddy.MainActivity.Companion.USER_TOKEN
import com.example.delibuddy.network.RetrofitClient
import com.example.delibuddy.network.model.SendMessageRequest
import com.example.delibuddy.presentation.chatroom.model.ChatHistoryDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ChatRoomViewModel : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _chatHistory = MutableStateFlow(emptyList<ChatHistoryDetail>())
    val chatHistory: StateFlow<List<ChatHistoryDetail>> = _chatHistory

    fun getChatHistory(roomId: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getChatHistory(roomId)

                if (response.isSuccessful) {
                    _chatHistory.value = response.body()?.chatHistory ?: emptyList()
                    _isLoading.value = true
                    Log.d("testt", response.body().toString())
                } else {
                    // 실패 시 처리
                    Log.d("testt", "Error: ${response.message()}")
                }
            } catch (e: Exception) {
                // 요청 실패 시 처리
                Log.d("testt", "Request failed: ${e.message}")
            }
        }
    }

    fun sendMessage(roomId: String, message: String) {
        _isLoading.value = false
        val sendMessage = SendMessageRequest(roomId, message)
        viewModelScope.launch {
            try {
                val response =
                    RetrofitClient.apiService.sendMessage("Bearer $USER_TOKEN", sendMessage)

                if (response.isSuccessful) {
                    getChatHistory(roomId)
                    _isLoading.value = true
                    Log.d("testt", response.body().toString())
                } else {
                    // 실패 시 처리
                    Log.d("testt", "Error: ${response.message()}")
                }
            } catch (e: Exception) {
                // 요청 실패 시 처리
                Log.d("testt", "Request failed: ${e.message}")
            }
        }
    }
}