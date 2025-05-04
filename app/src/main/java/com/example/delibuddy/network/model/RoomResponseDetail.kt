package com.example.delibuddy.network.model

import com.example.delibuddy.presentation.roomdetail.model.RoomDetailList
import com.google.gson.annotations.SerializedName

data class RoomResponseDetail(
    @SerializedName("message") val title: String,
    @SerializedName("group") val memberGroup: RoomDetailList
)