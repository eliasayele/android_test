package com.example.testandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.testandroid.ui.theme.TestandroidTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testandroid.ui.BottomNavItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }
    }
}
@Composable
private fun MainScreen() {
    TestandroidTheme {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = {
                BottomBarNavigation(
                navController = navController,
                items = listOf(
                    BottomNavItem(
                        name = "Home",
                        route = "home",
                        icon = Icons.Default.Home,
                    ),
                    BottomNavItem(
                        name = "chat",
                        route = "chat",
                        icon = Icons.Default.Notifications,
                    ),
                    BottomNavItem(
                        name = "Settings",
                        route = "settings",
                        icon = Icons.Default.Settings,
                    ),
                ),
             onItemClick ={
                 navController.navigate(it.route)
             }
            ) }
        ) {
            Navigation(navController = navController)
        }
    }
}

@Composable
fun BottomBarNavigation(
    items:List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomNavigation(modifier = modifier, backgroundColor = Color.White, elevation = 5.dp) {
        items.forEach { item ->
            val selected = item.route == currentRoute
            BottomNavigationItem(
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        Icon(
                            painter = painterResource(R.drawable.ic_headphones),
                            contentDescription = item.name
                        )
                        Text(text = item.name)
                    }
                   
                },
                selected = selected,
                onClick = {
                },
               selectedContentColor = Color.Cyan,
                unselectedContentColor = Color.Black,
               // label = {Text(NavRoute)}
            )
        }

    }
}

@Composable
fun Navigation(navController: NavHostController) {
    //startDestination = "subliminals"
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen("Starter")
        }
        //favourites
        composable("chat") {
           ChatScreen()
        }
        //journals
        composable("settings") {
           SettingsScreen()
        }
    }
}
@Composable
fun HomeScreen(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun ChatScreen() {
    Box {
        Text(text = "Chat Screen")
    }
}

@Composable
fun SettingsScreen() {
    Box {
        Text(text = "Settings Screen")
    }
}

