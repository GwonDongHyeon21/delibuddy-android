package com.example.delibuddy.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.delibuddy.navigation.BottomNavigationItem
import com.example.delibuddy.ui.theme.Gray1
import com.example.delibuddy.ui.theme.MainColor
import com.example.delibuddy.ui.theme.MainWhite

@Composable
fun BottomBar(navController: NavController) {
    var selectedItem by rememberSaveable { mutableStateOf("") }
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val bottomItems = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Send,
        BottomNavigationItem.Check,
        BottomNavigationItem.Person
    )

    LaunchedEffect(currentBackStackEntry) {
        selectedItem = currentBackStackEntry?.destination?.route ?: ""
    }

    NavigationBar(
        modifier = Modifier
            .height(80.dp)
            .background(MainWhite, RoundedCornerShape(27.dp))
            .shadow(12.dp, RoundedCornerShape(27.dp), spotColor = Gray1),
        containerColor = MainWhite
    ) {
        bottomItems.forEach { item ->
            NavigationBarItem(
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier.clickable(
                            interactionSource = null,
                            indication = null,
                            onClick = {
                                navController.navigate(item.destination) {
                                    selectedItem = item.destination
                                    popUpTo(bottomItems.first().destination) { inclusive = false }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    ) {
                        Icon(
                            painter = painterResource(item.icon),
                            contentDescription = item.destination,
                            modifier = Modifier
                                .size(36.dp)
                                .background(
                                    if (selectedItem == item.destination) MainColor
                                    else Color.Transparent,
                                    RoundedCornerShape(100)
                                )
                                .padding(6.dp)
                        )
                        Text(
                            text = item.destination,
                            style = TextStyle(fontSize = 10.sp)
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                ),
                selected = selectedItem == item.destination,
                onClick = { },
                modifier = Modifier.align(Alignment.CenterVertically),
                enabled = false
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    BottomBar(rememberNavController())
}