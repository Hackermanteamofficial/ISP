package com.example.j11.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.j11.screens.HomePageSecond
import com.example.j11.screens.ManagementScreen
import com.example.j11.screens.ProfileScreen

@Composable
fun AppNavHost(
    navController : NavHostController,
    startDestination: Destination,
    modifier: Modifier = Modifier
){
    NavHost(
        navController,
        startDestination = startDestination.route
    ){
        Destination.entries.forEach { destination ->
            composable (destination.route){
                when (destination) {
                    Destination.Home -> HomePageSecond()
                    Destination.Profile -> ProfileScreen()
                    Destination.Management -> ManagementScreen()
                }
            }
        }
    }
}