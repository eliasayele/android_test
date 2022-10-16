package com.example.testandroid

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.testandroid.ui.theme.TestandroidTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testandroid.models.BottomNavItem
import com.example.testandroid.ui.SelectableChip
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.text.style.TextAlign
import androidx.core.view.WindowCompat
import com.example.testandroid.models.Tracks
import com.example.testandroid.ui.components.TrackItem
import com.example.testandroid.ui.screens.FavouritesScreen
import com.example.testandroid.ui.screens.HomeScreen
import com.example.testandroid.ui.screens.JournalScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }
    }
}


@RequiresApi(Build.VERSION_CODES.N)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun MainScreen() {
    TestandroidTheme {
        val navController = rememberNavController()
        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp
        val systemUiController = rememberSystemUiController()
        systemUiController.setSystemBarsColor(color = Color.White)

        Box {
            /** background path */
            Column {
                Image(painter  = painterResource(R.drawable.firstshape), contentDescription ="" )
                Row(){
                    Spacer(modifier = Modifier.weight(7f, true))
                    Image(painter  = painterResource(R.drawable.secondshape),
                        contentDescription ="",
                        alignment = BottomEnd
                    )
                }


            }
            Scaffold(
                backgroundColor = Color.Transparent,
                topBar = {
                    Row(modifier = Modifier.padding(10.dp)) {
                        Icon(Icons.Default.Info,
                            contentDescription = "information",
                            modifier = Modifier.weight(1f, true)
                        )
                        Spacer(modifier = Modifier.weight(7f, true))
                        Icon(Icons.Outlined.Search, "Search",
                            modifier = Modifier
                                .weight(1f, true)
                                .background(Color(0xFFF6F9FA)))
                    }
                },
                bottomBar = {
                    BottomBarNavigation(
                        items = listOf(
                            BottomNavItem(
                                name = "Subliminals",
                                route = "subliminals",
                                icon = R.drawable.ic_headphones,
                            ),
                            BottomNavItem(
                                name = "Favourites",
                                route = "favourites",
                                icon = R.drawable.ic_hearticon,
                            ),
                            BottomNavItem(
                                name = "Journals",
                                route = "journals",
                                icon = R.drawable.ic_journalicon,
                            ),
                        ),
                        navController = navController,
                        onItemClick = {
                            navController.navigate(it.route)
                        }
                    ) }
            ) {
                Navigation(navController = navController)
            }
        }

    }
}

@Composable
fun BottomBarNavigation(
    items: List<BottomNavItem>,
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
                            painter = painterResource(item.icon),
                            contentDescription = item.name
                        )
                    }
                },
                selected = selected,
                onClick = {
                          onItemClick(item)
                },
               selectedContentColor = Color(0xFF6ABED0),
                unselectedContentColor = Color.Black,
                 label = {Text(item.name)}
            )
        }

    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "subliminals") {
        composable("subliminals") {
            HomeScreen()
        }
        composable("favourites") {
            FavouritesScreen()
        }
        composable("journals") {
           JournalScreen()
        }
    }
}


@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalFoundationApi
@Composable
fun DisplayList(items: List<Tracks>) {
    val listState = rememberLazyListState()

    LazyColumn(modifier = Modifier
        .fillMaxSize(1F)
        .padding(horizontal = 20.dp, vertical = 10.dp)
        .padding(bottom = 60.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        state = listState)
    {
        items(items) { item  ->
            TrackItem(item = item)
        }
    }
}

