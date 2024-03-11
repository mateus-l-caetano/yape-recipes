package com.mateus.yaperecipes.ui.presentation.recipes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun RecipeCard(title: String, imageUrl: String, onCLicked: () -> Unit, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .clickable { onCLicked() }
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            AsyncImage(
                imageUrl,
                "food image",
                modifier.fillMaxWidth().height(250.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = title,
                modifier = modifier.padding(8.dp),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}