package com.example.delibuddy.navigation.home

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.delibuddy.navigation.NavigationViewModel
import com.example.delibuddy.navigation.home.model.HomeToDetail
import com.example.delibuddy.presentation.roomadd.RoomAddScreen
import com.example.delibuddy.presentation.roomdetail.RoomDetailScreen
import com.example.delibuddy.presentation.roomlist.RoomListScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeNavigationGraph(viewModel: NavigationViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeNavigationItem.RoomList.destination
    ) {
        composable(HomeNavigationItem.RoomList.destination) {
            viewModel.bottomEnableTrue()
            RoomListScreen(navController)
        }
        composable(HomeNavigationItem.RoomAdd.destination) {
            viewModel.bottomEnableFalse()
            RoomAddScreen(navController)
        }
        composable(
            route = HomeNavigationItem.RoomDetail.destination
                    + "/{roomId}/{roomName}/{roomContent}/{roomTagChips}/{roomStatus}/{totalCost}"
        ) { backStackEntry ->
            val roomId = backStackEntry.arguments?.getString("roomId").toString()
            val roomName = backStackEntry.arguments?.getString("roomName").toString()
            val roomContent = backStackEntry.arguments?.getString("roomContent").toString()
            val roomTagChips = backStackEntry.arguments?.getString("roomTagChips").toString()
            val roomStatus = backStackEntry.arguments?.getString("roomStatus").toString()
            val totalCost = backStackEntry.arguments?.getString("totalCost").toString()
            val roomDetail =
                HomeToDetail(roomId, roomName, roomContent, roomTagChips, roomStatus, totalCost)

            viewModel.bottomEnableFalse()
            RoomDetailScreen(navController, roomDetail)
        }
    }
}
