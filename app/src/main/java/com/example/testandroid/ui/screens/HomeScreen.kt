package com.example.testandroid.ui.screens

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testandroid.DisplayList
import com.example.testandroid.models.Tracks
import com.example.testandroid.R
import com.example.testandroid.models.getAllCategories
import com.example.testandroid.models.getIndexedCategory
import com.example.testandroid.models.listItems
import com.example.testandroid.ui.CategoryChip
import com.example.testandroid.viewmodels.HomeViewModel

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {

    val selectedCategory = viewModel.selectedCategory.value
    val  isFirstItemSelected = viewModel.isFistItemSelected.value

    val scrollState = rememberScrollState()

    Box(modifier = Modifier.fillMaxHeight()) {
        Column(modifier = Modifier.padding(top = 10.dp)) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                text = "Good morning!",
                color = Color.Black,
                fontSize = 28.sp,
                style = MaterialTheme.typography.h1,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 5.dp),
                text = "Your daily dose of subliminals is ready",
                color = Color(0xFF415871),
                style = MaterialTheme.typography.subtitle1,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(modifier = Modifier.padding(top = 15.dp, bottom = 10.dp, start = 10.dp).horizontalScroll(scrollState)){
                getAllCategories().forEachIndexed { index, size ->
                    getIndexedCategory(index)?.let {
                        CategoryChip(
                            category = it.value,
                            isSelected = selectedCategory == it,
                            onSelectedCategoryChanged = {
                                viewModel.onUnselectedFirstItem()
                                viewModel.onSelectedCategoryChanged(it)
                            },
                            initial = index == 0 && isFirstItemSelected
                        )
                    }
                }
            }
            DisplayList(items = listItems)
        }

    }
}




