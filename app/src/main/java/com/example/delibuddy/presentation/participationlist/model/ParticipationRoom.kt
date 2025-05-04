package com.example.delibuddy.presentation.participationlist.model

import com.google.gson.annotations.SerializedName

data class ParticipationRoom(
    @SerializedName("groupId") val roomId: String,
    @SerializedName("title") val restaurantName: String,
    @SerializedName("note") val roomContent: String,
    @SerializedName("status") val roomStatus: Int,
    @SerializedName("icons") val illustrations: List<Int>,
    @SerializedName("hashtags") val tagChips: List<String>,
    @SerializedName("creator") val creatorId: String
)