package com.example.testandroid.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testandroid.models.Tracks

@Composable
fun TrackItem(item: Tracks) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(115.dp)
            .clip(RoundedCornerShape(26.dp))
            .background(Color.White)
            .padding(horizontal = 15.dp, vertical = 5.dp)
    ){
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 13.dp)
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "user icon",
                contentScale = ContentScale.Crop,            // crop the image if it's not a square
                modifier = Modifier
                    .size(75.dp)
                    .clip(CircleShape)                       // clip to the circle shape
                    .border(1.dp, Color.Gray, CircleShape)   // add a border (optional)
            )
            Column(modifier = Modifier.align(Alignment.CenterVertically).width(220.dp)) {
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = item.name,
                    color = Color(0xFF1D2339),
                    style = MaterialTheme.typography.body1,
                    fontSize = 15.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp).padding(top = 5.dp),
                    text = item.description,
                    color = Color.Gray,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }
}