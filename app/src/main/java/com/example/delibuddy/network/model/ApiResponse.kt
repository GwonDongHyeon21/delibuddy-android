package com.example.delibuddy.network.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("message") val responseMessage: String
)