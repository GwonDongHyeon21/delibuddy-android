package com.example.delibuddy.presentation.roomadd.model

import com.google.gson.annotations.SerializedName

data class RoomDetail(
    @SerializedName("title") val restaurantName: String,
    @SerializedName("note") val content: String,
    @SerializedName("foodCategory") val foodCategory: String,
    @SerializedName("maxPeople") val totalPeople: Int,
    @SerializedName("together") val isTogether: Boolean,
    @SerializedName("sameGender") val gender: Boolean,
    @SerializedName("hashtags") val hashTags: List<String>,
    @SerializedName("location") val location: String,
    @SerializedName("cost") val userCost: Int,
    @SerializedName("hopeCost") val totalCost: Int
)