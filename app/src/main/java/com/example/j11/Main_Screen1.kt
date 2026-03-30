package com.example.j11

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.WifiProtectedSetup
import androidx.compose.material.icons.filled.WifiTetheringErrorRounded
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.WifiProtectedSetup
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.j11.navigation.AppNavHost
import com.example.j11.navigation.Destination
import kotlinx.coroutines.selects.select

@Composable
fun BottomNavBar(){
    val items = listOf(
        NavItemState(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        ),
        NavItemState(
            title = "Profile",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person
        ),
        NavItemState(
            title = "Setting",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings
        ),
        NavItemState(
            title = "Management",
            selectedIcon = Icons.Filled.WifiProtectedSetup,
            unselectedIcon = Icons.Outlined.WifiProtectedSetup
        ),
    )

    var bottomNavState by rememberSaveable {
        mutableIntStateOf(0)
    }
    Scaffold (
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                       selected = bottomNavState == index,
                        onClick = { bottomNavState = index },
                        icon = { Icon(
                            imageVector =
                                if (bottomNavState == index){
                                item.selectedIcon
                            }else{
                                item.unselectedIcon
                            },
                            contentDescription = item.title
                        ) },
                        label = {item.title}

                    )
                }
            }
        }
    ){ contentPadding ->
        Column (
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                items[bottomNavState].title
            )
        }
    }
}