package com.example.testandroid.ui


import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testandroid.models.Tracks


@Composable
fun CategoryChip(
    category: String,
    isSelected: Boolean = false,
    onSelectedCategoryChanged: (String) -> Unit,
    initial:Boolean = false
){

    Surface(
        modifier = Modifier.padding(4.dp),
        shape = MaterialTheme.shapes.small,
        color = if (isSelected ) Color(0xFF1D2339) else if(initial) Color(0xFF1D2339) else Color(0xFFF6F9FA)
    ) {
        Row(modifier = Modifier
            .toggleable(
                value = isSelected,
                onValueChange = {
                    onSelectedCategoryChanged(category)
                }
            )
            .padding(horizontal = 10.dp, vertical = 2.dp)
        ) {
            Text(
                text = category,
                style = MaterialTheme.typography.subtitle1.copy(color = if (isSelected) Color.White else if(initial) Color.White else Color(0xFF8A8E9A), fontSize = 12.sp),
                modifier = Modifier.padding(8.dp)
            )
        }
    }

}



