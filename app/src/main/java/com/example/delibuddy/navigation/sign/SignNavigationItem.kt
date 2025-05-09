package com.example.delibuddy.navigation.sign

sealed class SignNavigationItem(val destination: String) {
    data object SignIn : SignNavigationItem("로그인")
    data object SignUp : SignNavigationItem("회원가입")
    data object BottomNavigationGraph : SignNavigationItem("BottomNavigationGraph")
}