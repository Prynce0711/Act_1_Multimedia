package com.example.act_1_multimedia.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.act_1_multimedia.screens.Activity1Screen
import com.example.act_1_multimedia.screens.ChangePasswordScreen
import com.example.act_1_multimedia.screens.ContactScreen
import com.example.act_1_multimedia.screens.ExperienceScreen
import com.example.act_1_multimedia.screens.HomeScreen
import com.example.act_1_multimedia.screens.LoginScreen
import com.example.act_1_multimedia.screens.MainScreen
import com.example.act_1_multimedia.screens.ProjectsScreen
import com.example.act_1_multimedia.screens.SignUpScreen
import com.example.act_1_multimedia.screens.SkillsScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        composable("activity1") { Activity1Screen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("signup") { SignUpScreen(navController) }
        composable(
            "home?username={username}",
            arguments = listOf(navArgument("username") { 
                type = NavType.StringType
                nullable = true
            })
        ) { backStackEntry ->
            HomeScreen(navController, backStackEntry.arguments?.getString("username"))
        }
        composable("change_password") { 
            ChangePasswordScreen(navController, null)
        }
        composable("projects") { ProjectsScreen(navController) }
        composable("skills") { SkillsScreen(navController) }
        composable("experience") { ExperienceScreen(navController) }
        composable("contact") { ContactScreen(navController) }
    }
}
