package com.example.delibuddy.network.model

import com.example.delibuddy.presentation.roomdetail.model.User
import com.google.gson.annotations.SerializedName

data class UserDetailResponse(
    @SerializedName("message") val message:String,
    @SerializedName("user") val userDetailList: User
)