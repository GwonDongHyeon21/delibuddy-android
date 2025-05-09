package com.example.delibuddy.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.delibuddy.navigation.chat.ChatNavigationGraph
import com.example.delibuddy.navigation.home.HomeNavigationGraph
import com.example.delibuddy.navigation.participation.ParticipationNavigationGraph
import com.example.delibuddy.navigation.user.UserScreenNavigation
import com.example.delibuddy.presentation.component.BottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigationGraph(viewModel: NavigationViewModel = viewModel()) {
    val navController = rememberNavController()
    val isButton by viewModel.isBottom.collectAsState()

    Scaffold(
        bottomBar = { if (isButton) BottomBar(navController) }
    ) {
        NavHost(
            navController = navController,
            startDestination = BottomNavigationItem.Home.destination
        ) {
            composable(BottomNavigationItem.Home.destination) {
                HomeNavigationGraph(viewModel)
            }
            composable(BottomNavigationItem.Send.destination) {
                ChatNavigationGraph(viewModel)
            }
            composable(BottomNavigationItem.Check.destination) {
                ParticipationNavigationGraph(viewModel)
            }
            composable(BottomNavigationItem.Person.destination) {
                UserScreenNavigation()
            }
        }
    }
}