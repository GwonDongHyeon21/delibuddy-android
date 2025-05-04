package com.example.delibuddy.network.model

import com.google.gson.annotations.SerializedName

data class VerifyCodeRequest(
    @SerializedName("email") val email: String
)