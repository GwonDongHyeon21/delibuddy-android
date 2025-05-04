package com.example.delibuddy.network.model

import com.google.gson.annotations.SerializedName

data class SearchQuery(
    @SerializedName("groupId") val roomId: String,
    @SerializedName("myCost") val userCost: Int
)
