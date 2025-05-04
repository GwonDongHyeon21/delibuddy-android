package com.example.delibuddy.navigation.sign

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.delibuddy.navigation.BottomNavigationGraph
import com.example.delibuddy.presentation.signin.SignInScreen
import com.example.delibuddy.presentation.signup.SignUpScreen

@Composable
fun SignNavigationGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SignNavigationItem.SignIn.destination
    ) {
        composable(SignNavigationItem.SignIn.destination) {
            SignInScreen(navController)
        }
        composable(SignNavigationItem.SignUp.destination) {
            SignUpScreen(navController)
        }
        composable(SignNavigationItem.BottomNavigationGraph.destination) {
            BottomNavigationGraph()
        }
    }
}