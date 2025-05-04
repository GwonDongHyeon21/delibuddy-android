package com.example.delibuddy.navigation.chat

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.delibuddy.navigation.NavigationViewModel
import com.example.delibuddy.presentation.chatlist.ChatListScreen
import com.example.delibuddy.presentation.chatroom.ChatRoomScreen

@Composable
fun ChatNavigationGraph(viewModel: NavigationViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ChatNavigationItem.ChatList.destination
    ) {
        composable(ChatNavigationItem.ChatList.destination) {
            viewModel.bottomEnableTrue()
            ChatListScreen(navController)
        }
        composable(
            route = ChatNavigationItem.ChatRoom.destination + "/{roomId}"
        ) { backStackEntry ->
            val roomId = backStackEntry.arguments?.getString("roomId").toString()

            viewModel.bottomEnableFalse()
            ChatRoomScreen(navController, roomId)
        }
    }
}