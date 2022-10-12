package com.example.testandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.testandroid.ui.theme.TestandroidTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

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
            bottomBar = { BottomBarNavigation(navController = navController) }
        ) { paddingValues ->
            NavGraph(
                modifier = Modifier.padding(
                    bottom = paddingValues.calculateBottomPadding()),
                navController = navController
            )
        }
    }
}

@Composable
fun BottomBarNavigation(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    if (currentRoute == null || currentRoute == NavRoute.Login.path) {
        return
    }

    BottomNavigation {
        val homeSelected = currentRoute == NavRoute.Home.path
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_headphones),
                    contentDescription = NavRoute.Home.path
                )
            },
            selected = homeSelected,
            onClick = {
                if(!homeSelected) {
                    navController.navigate(NavRoute.Home.path) {
                        popUpTo(NavRoute.Home.path) { inclusive = true }
                    }
                }
            },
            label = {Text(NavRoute.Home.path)}
        )
    }
}
@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavRoute.Login.path
    ) {
        /*...*/
    }
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestandroidTheme {
        Greeting("Android")
    }
}