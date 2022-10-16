package com.example.testandroid.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testandroid.DisplayList
import com.example.testandroid.models.Tracks
import com.example.testandroid.ui.SelectableChip
import com.example.testandroid.R

@OptIn(ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()

    /** dummy data from local, get from figma */
    val listItems: List<Tracks> = listOf(
        Tracks("Female Super Model Subliminal", image = R.drawable.model_pic1, description ="Become physically attractive" ),
        Tracks("Greek God Physique Subliminal v3.1",image = R.drawable.model_pic2, description = "Fitness & wellness"),
        Tracks("The most amazing subliminal for you",image = R.drawable.model_pic3, description = "Design your future"),
        Tracks("Strongest Subliminal Booster v3.1",image = R.drawable.model_pic4, description = "Get faster results"),
        Tracks("Female Super Model Subliminal",image = R.drawable.model_pic1, description = "Become physically attractive"),
        Tracks("Greek God Physique Subliminal v3.1",image = R.drawable.model_pic2,description="Fitness & wellness"),
        Tracks("The most amazing subliminal for you",image = R.drawable.model_pic3, description = "Get faster results"),
        Tracks("Strongest Subliminal Booster v3.1",image = R.drawable.model_pic4, description = "Design your future"),
        Tracks("Female Super Model Subliminal",image = R.drawable.model_pic1, description = "Become physically attractive"),
        Tracks("Greek God Physique Subliminal v3.1",image = R.drawable.model_pic2,description="Fitness & wellness"),
        Tracks("The most amazing subliminal for you",image = R.drawable.model_pic3, description = "Get faster results"),
        Tracks("Female Super Model Subliminal",image = R.drawable.model_pic4, description = "Design your future")
    )
    Box(modifier = Modifier.fillMaxHeight()) {
        Column {
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                text = "Good morning!",
                color = Color.Black,
                fontSize = 30.sp,
                style = MaterialTheme.typography.h1,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                text = "Your daily dose of subliminals is ready",
                color = Color(0xFF415871),
                style = MaterialTheme.typography.subtitle1,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(modifier =
            Modifier
                .horizontalScroll(scrollState)
            ) {
                SelectableChip("All together",true) {}
                SelectableChip("For women",false) {}
                SelectableChip("For men",false) {}
                SelectableChip("Health & Wellness",false) {}
                SelectableChip("Happy",false) {}
            }
            DisplayList(items = listItems)
        }

    }
}
