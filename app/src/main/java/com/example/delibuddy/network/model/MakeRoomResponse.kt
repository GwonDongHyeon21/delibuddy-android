package com.example.delibuddy.network.model

import com.google.gson.annotations.SerializedName

data class MakeRoomResponse(
    @SerializedName("message") val message: String,
    @SerializedName("groupId") val groupId: String
)