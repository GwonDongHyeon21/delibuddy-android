package com.example.delibuddy.network.model

import com.google.gson.annotations.SerializedName

data class SignInResponse(
    @SerializedName("message") val message: String,
    @SerializedName("token") val userToken: String,
    @SerializedName("userId") val userId: String
)