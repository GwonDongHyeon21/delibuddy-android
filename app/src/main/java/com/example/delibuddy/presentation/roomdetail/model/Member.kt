package com.example.delibuddy.presentation.roomdetail.model

import com.google.gson.annotations.SerializedName

data class Member(
    @SerializedName("userId") val userId: String,
    @SerializedName("nickname") val nickName: String,
    @SerializedName("icon") val illustration: Int,
    @SerializedName("major") val department: String,
    @SerializedName("studentId") val year: Int,
    @SerializedName("likeCount") val favoriteCount: Int
)