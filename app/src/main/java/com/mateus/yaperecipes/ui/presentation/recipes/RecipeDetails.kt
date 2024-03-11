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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.mateus.yaperecipes.R
import com.mateus.yaperecipes.domain.model.Recipe

@Composable
fun RecipeDetails(recipesViewModel: RecipesViewModel, recipeId: Int, modifier: Modifier = Modifier) {
    val recipes by recipesViewModel.recipes.collectAsStateWithLifecycle()
    val recipe : Recipe? = recipes.data?.recipes?.first { it.id == recipeId }

    Box(
        modifier
            .fillMaxSize().padding(0.dp)) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AsyncImage(
                recipe?.image.orEmpty(),
                "food image",
                modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop
            )

            LazyColumn(
                modifier.padding(horizontal = 8.dp).padding(bottom = 8.dp)
            ) {
                val ingredients = recipe?.ingredients.orEmpty()
                val steps = recipe?.preparationSteps.orEmpty()

                item {
                    Text(
                        recipe?.name.orEmpty(),
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