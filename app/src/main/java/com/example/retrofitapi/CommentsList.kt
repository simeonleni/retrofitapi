package com.example.retrofitapi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp

@Composable
fun CommentsList(comments: List<Comments>) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .padding(start = 8.dp),
                colorFilter = ColorFilter.tint(Color.LightGray)
            )

            Divider()
            
            Text(
                text = "Supp Lab",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(2.dp)
            )

            Text(
                text = "Retrofit API",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(2.dp)
            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Load Data")
            }
        }

        LazyColumn {
            items(comments) { comment ->
                CommentItem(comment = comment)
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

