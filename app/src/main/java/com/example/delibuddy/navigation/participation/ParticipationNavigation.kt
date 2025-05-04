package com.example.delibuddy.navigation.participation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.delibuddy.navigation.NavigationViewModel
import com.example.delibuddy.navigation.home.model.HomeToDetail
import com.example.delibuddy.presentation.participationlist.ParticipationListScreen
import com.example.delibuddy.presentation.participationdetail.ParticipationDetailScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ParticipationNavigationGraph(viewModel: NavigationViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ParticipationNavigationItem.ParticipationList.destination
    ) {
        composable(ParticipationNavigationItem.ParticipationList.destination) {
            viewModel.bottomEnableTrue()
            ParticipationListScreen(navController)
        }
        composable(
            route = ParticipationNavigationItem.ParticipationDetail.destination +
                    "/{roomId}/{roomName}/{roomContent}/{roomTagChips}/{roomStatus}"
        ) { backStackEntry ->
            val roomId = backStackEntry.arguments?.getString("roomId").toString()
            val roomName = backStackEntry.arguments?.getString("roomName").toString()
            val roomContent = backStackEntry.arguments?.getString("roomContent").toString()
            val roomTagChips = backStackEntry.arguments?.getString("roomTagChips").toString()
            val roomStatus = backStackEntry.arguments?.getString("roomStatus").toString()
            val roomDetail =
                HomeToDetail(roomId, roomName, roomContent, roomTagChips, roomStatus, "")

            viewModel.bottomEnableFalse()
            ParticipationDetailScreen(navController, roomDetail)
        }
    }
}