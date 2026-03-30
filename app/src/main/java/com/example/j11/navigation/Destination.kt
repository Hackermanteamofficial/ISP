package com.example.j11.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ControlPoint
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.ControlPoint
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Person4
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class Destination(
    val route: String,
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val contentDescription: String,
) {
    Home(
        route = "home",
        label = "Home",
        selectedIcon = Icons.Default.Home,
        unselectedIcon = Icons.Outlined.Home,
        contentDescription = "Home Page"
    ),
    Management(
        route = "management",
        label = "Management",
        selectedIcon = Icons.Default.ControlPoint,
        unselectedIcon = Icons.Outlined.ControlPoint,
        contentDescription = "Management Page"
    ),
    Profile(
        route = "profile",
        label = "Profile",
        selectedIcon = Icons.Default.Person,
        unselectedIcon = Icons.Outlined.Person,
        contentDescription = "Profile Page"
    ),
}