package com.example.delibuddy.presentation.signin

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.delibuddy.R
import com.example.delibuddy.navigation.sign.SignNavigationItem
import com.example.delibuddy.presentation.signin.component.SignOptions
import com.example.delibuddy.ui.theme.Brown2
import com.example.delibuddy.ui.theme.Gray3
import com.example.delibuddy.ui.theme.InnerPadding
import com.example.delibuddy.ui.theme.MainColor
import com.example.delibuddy.ui.theme.MainWhite
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun SignInScreen(
    navController: NavController,
    viewModel: SignInViewModel = viewModel()
) {
    val context = LocalContext.current
    val isSignIn by viewModel.isSignIn.collectAsState()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val isSignInError by viewModel.responseError.collectAsState()

    LaunchedEffect(isSignIn) {
        if (isSignIn)
            navController.navigate(SignNavigationItem.BottomNavigationGraph.destination) {
                popUpTo(SignNavigationItem.SignIn.destination) { inclusive = true }
            }
    }
    LaunchedEffect(isSignInError) {
        if (isSignInError)
            Toast.makeText(context, "이메일이나 비밀번호를 다시 확인해주세요.", Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainColor)
            .padding(InnerPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(3f))
        Image(
            painter = painterResource(R.drawable.app_loading),
            contentDescription = "logo"
        )

        Spacer(Modifier.weight(1f))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = {
                Text(
                    text = "학교 이메일 입력",
                    style = TextStyle(color = Gray3),
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(MainWhite, RoundedCornerShape(8.dp)),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
            ),
            maxLines = 1
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = {
                Text(
                    text = "비밀번호",
                    style = TextStyle(color = Gray3)
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .background(MainWhite, RoundedCornerShape(8.dp)),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            maxLines = 1
        )

        Spacer(Modifier.height(8.dp))
        Button(
            onClick = {
                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.signIn(context, email, password)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .background(Brown2, RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Text(text = "로그인")
        }

        Spacer(Modifier.height(16.dp))
        SignOptions(
            onIdClick = { },
            onPasswordClick = { },
            onSignUpClick = { navController.navigate(SignNavigationItem.SignUp.destination) }
        )
        Spacer(Modifier.weight(2f))
    }
}

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    SignInScreen(rememberNavController())
}