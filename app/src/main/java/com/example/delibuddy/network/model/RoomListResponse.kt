package com.example.delibuddy.network.model

import com.example.delibuddy.presentation.roomlist.model.Room
import com.google.gson.annotations.SerializedName

data class RoomListResponse(
    @SerializedName("message") val message: String,
    @SerializedName("groups") val roomList: List<Room>
)