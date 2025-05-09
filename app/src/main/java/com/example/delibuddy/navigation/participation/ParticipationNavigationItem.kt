package com.example.delibuddy.navigation.participation

sealed class ParticipationNavigationItem(val destination: String) {
    data object ParticipationList : ParticipationNavigationItem("거래내역")
    data object ParticipationDetail : ParticipationNavigationItem("상세보기")
}