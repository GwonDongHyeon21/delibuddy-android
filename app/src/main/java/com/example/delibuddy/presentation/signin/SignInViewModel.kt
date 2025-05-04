package com.example.delibuddy.presentation.signin

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.delibuddy.MainActivity.Companion.USER_ID
import com.example.delibuddy.MainActivity.Companion.USER_TOKEN
import com.example.delibuddy.network.RetrofitClient
import com.example.delibuddy.network.model.SignInRequest
import com.example.delibuddy.network.model.SignInResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInViewModel : ViewModel() {
    private val _isSignIn = MutableStateFlow(false)
    val isSignIn: StateFlow<Boolean> = _isSignIn

    private val _responseError = MutableStateFlow(false)
    val responseError: StateFlow<Boolean> = _responseError

    fun signIn(context: Context, email: String, password: String) {
        val requestBody = SignInRequest(email, password)
        RetrofitClient.apiService.signInRequest(requestBody)
            .enqueue(object : Callback<SignInResponse> {
                override fun onResponse(
                    call: Call<SignInResponse>,
                    response: Response<SignInResponse>
                ) {
                    if (response.isSuccessful) {
                        _isSignIn.value = true
                        USER_TOKEN = response.body()?.userToken.toString()
                        USER_ID = response.body()?.userId.toString()
                        saveUserUserToken(context, USER_TOKEN, USER_ID)
                    } else {
                        _responseError.value = true
                    }
                }

                override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                    Log.d("signIn", t.message.toString())
                }
            })
    }

    fun saveUserUserToken(context: Context, userToken: String, userId: String) {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences("DelibuddyUserPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("delibuddyUserToken", userToken)
        editor.putString("delibuddyUserId", userId)
        editor.apply()
    }

    fun removeUserToken(context: Context) {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences("DelibuddyUserPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.remove("delibuddyUserToken")
        editor.remove("delibuddyUserId")
        editor.apply()
    }
}