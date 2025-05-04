package com.example.delibuddy.network.model

import com.google.gson.annotations.SerializedName

data class BlockUserIdRequest(
    @SerializedName("targetUserId") val userId: String
)