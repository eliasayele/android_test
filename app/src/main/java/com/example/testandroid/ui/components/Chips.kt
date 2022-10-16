package com.example.testandroid.ui


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun Chip(
    startIcon: () -> ImageVector? = { null },
    isStartIconEnabled: Boolean = false,
    startIconTint: Color = Color.Unspecified,
    onStartIconClicked: () -> Unit = { },
    endIcon: () -> Unit = { null },
    isEndIconEnabled: Boolean = false,
    endIconTint: Color = Color.Unspecified,
    onEndIconClicked: () -> Unit = { },
    color: Color = Color.Gray,
    labelColor:Color =  Color.White,
    label: String,
    isClickable: Boolean = false,
    onClick: () -> Unit = { }
) {
    Surface(
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp).clickable(
            enabled = isClickable,
            onClick = { onClick() }
        ),
        shape = MaterialTheme.shapes.small,
        color = color
    ) {
        Text(
            label,
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.button.copy(color = labelColor),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun SelectableChip(
    label: String,
    selected: Boolean,
    onClick: (nowSelected: Boolean) -> Unit
) {
    Chip(
        startIcon = { if (selected) Icons.Default.Check else null },
        label = label,
        labelColor = if (selected) Color.White else Color(0xFF8A8E9A),
        color =if (selected) Color(0xFF1D2339) else Color(0xFFF6F9FA),
        isClickable = true
    ) { onClick(!selected) }
}

