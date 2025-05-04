package com.example.delibuddy.presentation.roomdetail.model

import com.google.gson.annotations.SerializedName

data class RoomDetailList(
    @SerializedName("location") val location: String,
    @SerializedName("membersInfo") val members: List<Member>
)