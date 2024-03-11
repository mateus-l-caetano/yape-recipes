package com.mateus.yaperecipes.ui.presentation.recipes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mateus.yaperecipes.R
import com.mateus.yaperecipes.ui.theme.YapeRecipesTheme

@Composable
fun RecipeDetails(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxSize().padding(0.dp)) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AsyncImage(
                "https://images.unsplash.com/photo-1607301405390-d831c242f59b?q=80&w=3270&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                "food image",
                modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop
            )

            LazyColumn {
                val ingredients = listOf<String>(
                    "ingredients 1", "ingredients 2", "ingredients 3", "ingredients 4", "ingredients 5"
                )
                val steps = listOf<String>(
                    "step 1", "step 2", "step 3", "step 4", "step 5"
                )

                item {
                    Text(
                        "Recipe name",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = modifier.padding(vertical = 8.dp)
                    )
                }

                item {
                    Text(
                        "Ingredients",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = modifier.padding(bottom = 8.dp)
                    )
                }

                items(ingredients) { ingredient ->
                    Text(text = ingredient)
                }

                item {
                    Text(
                        "Steps",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = modifier.padding(vertical = 8.dp)
                    )
                }

                items(steps) { step ->
                    Text(text = step)
                }
            }
        }

        SmallFloatingActionButton(
            onClick = { /*TODO*/ },
            modifier = modifier
                .padding(8.dp),
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            Icon(
                painterResource(id = R.drawable.arrow_back),
                "back button"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeDetailPreview() {
    YapeRecipesTheme {
        RecipeDetails()
    }
}