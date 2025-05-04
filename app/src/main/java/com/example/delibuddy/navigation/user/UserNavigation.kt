package com.example.delibuddy.navigation.user

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.delibuddy.presentation.user.DeleteAccountScreen
import com.example.delibuddy.presentation.user.EditProfileScreen
import com.example.delibuddy.presentation.user.EditProfileViewModel
import com.example.delibuddy.presentation.user.FaqScreenWrapper
import com.example.delibuddy.presentation.user.InquiryFormScreen
import com.example.delibuddy.presentation.user.InquiryHistoryScreen
import com.example.delibuddy.presentation.user.InquiryScreen
import com.example.delibuddy.presentation.user.NoticeScreen
import com.example.delibuddy.presentation.user.NotificationSettingScreen
import com.example.delibuddy.presentation.user.PolicyScreen
import com.example.delibuddy.presentation.user.UserScreen

@Composable
fun UserScreenNavigation() {
    val navController = rememberNavController()
    val sharedViewModel: EditProfileViewModel = viewModel()

    NavHost(navController = navController, startDestination = "user_screen") {
        composable("user_screen") {
            UserScreen(navController = navController, viewModel = sharedViewModel)
        }
        composable("edit_profile_screen") {
            EditProfileScreen(navController = navController, viewModel = sharedViewModel)
        }
        composable("notification_setting") {
            NotificationSettingScreen(navController) // 🔸 알림설정 화면 추가
        }
        composable("policy") {
            PolicyScreen(navController)
        }
        composable("notice") {
            NoticeScreen(navController)
        }
        composable("inquiry") {
            InquiryScreen(navController)
        }
        composable("faq") {
            FaqScreenWrapper(navController = navController)
        }
        composable("inquiry_form") {
            InquiryFormScreen(navController)
        }
        composable("inquiry_history") {
            InquiryHistoryScreen(navController)
        }
        composable("deleteAccount") {
            DeleteAccountScreen(navController)
        }
    }
}
