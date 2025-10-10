package com.example.act_1_multimedia.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun Activity2Screen(navController: NavController) {
    navController.navigate("login") {
        popUpTo("activity2") {
            inclusive = true
        }
    }
}
