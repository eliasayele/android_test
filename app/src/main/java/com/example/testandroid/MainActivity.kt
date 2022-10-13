package com.example.testandroid

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.graphics.Color
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
        Scaffold(
            topBar = {
                Row(modifier = Modifier.padding(10.dp)) {
                    Icon(Icons.Outlined.Info, contentDescription = "information",modifier = Modifier.weight(1f, true))
                    Spacer(modifier = Modifier.weight(7f, true))
                    Icon(Icons.Filled.Search, "Search",modifier = Modifier.weight(1f, true))
                }
            },
            bottomBar = {
                BottomBarNavigation(
                navController = navController,
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
                            painter = painterResource(item.icon),
                            contentDescription = item.name
                        )
                        //Text(text = item.name)
                    }
                   
                },
                selected = selected,
                onClick = {
                          onItemClick
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
    //startDestination = "subliminals"
    NavHost(navController = navController, startDestination = "subliminals") {
        composable("subliminals") {
            HomeScreen()
        }
        //favourites
        composable("favourites") {
           ChatScreen()
        }
        //journals
        composable("journals") {
           SettingsScreen()
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun HomeScreen() {
    val listItems: List<ListItem> = listOf(
        ListItem("Female Super Model Subliminal", image = R.drawable.model_pic1, description ="Become physically attractive" ),
        ListItem("Greek God Physique Subliminal v3.1",image = R.drawable.model_pic2, description = "Fitness & wellness"),
        ListItem("The most amazing subliminal for you",image = R.drawable.model_pic3, description = "Design your future"),
        ListItem("Strongest Subliminal Booster v3.1",image = R.drawable.model_pic4, description = "Get faster results"),
        ListItem("Female Super Model Subliminal",image = R.drawable.model_pic1, description = "Become physically attractive"),
        ListItem("Greek God Physique Subliminal v3.1",image = R.drawable.model_pic2,description="Fitness & wellness"),
        ListItem("The most amazing subliminal for you",image = R.drawable.model_pic3, description = "Get faster results"),
        ListItem("Strongest Subliminal Booster v3.1",image = R.drawable.model_pic4, description = "Design your future"),
        ListItem("Female Super Model Subliminal",image = R.drawable.model_pic1, description = "Become physically attractive"),
        ListItem("Greek God Physique Subliminal v3.1",image = R.drawable.model_pic2,description="Fitness & wellness"),
        ListItem("The most amazing subliminal for you",image = R.drawable.model_pic3, description = "Get faster results"),
        ListItem("Female Super Model Subliminal",image = R.drawable.model_pic4, description = "Design your future")
    )
    Box(modifier = Modifier.fillMaxHeight()) {
        Column() {
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                text = "Good morning!",
                color = Color.Black,
                fontSize = 30.sp,
                style = MaterialTheme.typography.h1,
                fontWeight = FontWeight.Bold,
                //fontFamily = FontFamily.Gilroy,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                text = "Your daily dose of subliminals is ready",
                color = Color(0xFF415871),
                style = MaterialTheme.typography.body1,
                fontSize = 14.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(modifier = Modifier.padding(8.dp)) {
                SelectableChip("All Members","",true) {}
                SelectableChip("For women","",false) {}
                SelectableChip("For men","",false) {}
                SelectableChip("Health & Wellness","",false) {}
                SelectableChip("Happy","",false) {}
            }
            DisplayList(items = listItems)
        }

    }
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
data class ListItem(val name: String,val image: Int,val description: String)

@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalFoundationApi
@Composable
fun DisplayList(items: List<ListItem>) {
    val listState = rememberLazyListState()

    LazyColumn(modifier = Modifier.fillMaxSize(1F), state = listState) {
        items(items) { item  ->
            ListItem(item = item)

        }
//        CoroutineScope(Dispatchers.IO).launch {
//            listState.scrollToItem(items.size-1)
//        }
    }
}

@Composable
fun ListItem(item: ListItem) {
    Box(

    ) {
        Card(shape = RoundedCornerShape(10.dp), modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .height(120.dp)
            .background(color = Color.White)) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = "user icon",
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .padding(horizontal = 8.dp)
                        .align(CenterVertically)

                )
                Column(modifier = Modifier.align(CenterVertically)) {
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = item.name,
                        color = Color(0xFF1D2339),
                        style = MaterialTheme.typography.body1,
                        fontSize = 18.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = item.description,
                        color = Color.Gray,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Light,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

            }
        }


    }
}