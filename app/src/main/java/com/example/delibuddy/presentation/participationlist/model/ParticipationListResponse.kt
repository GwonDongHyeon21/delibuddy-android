package com.example.delibuddy.presentation.participationlist.model

import com.google.gson.annotations.SerializedName

data class ParticipationListResponse(
    @SerializedName("message") val title: String,
    @SerializedName("groups") val roomDerail: List<ParticipationRoom>
)