package com.mateus.yaperecipes.ui.presentation.recipes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.mateus.yaperecipes.R
import com.mateus.yaperecipes.domain.model.Recipe

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetails(
    recipesViewModel: RecipesViewModel,
    recipeId: Int,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val recipes by recipesViewModel.recipes.collectAsStateWithLifecycle()
    val recipe : Recipe? = recipes.data?.recipes?.first { it.id == recipeId }

    Scaffold(
        modifier
            .fillMaxSize()
            .padding(0.dp),
        topBar = {
            TopAppBar(
                title = {
                    Text("Recipe details")
                },
                navigationIcon = {
                    Icon(
                        painterResource(id = R.drawable.arrow_back),
                        "back button",
                        modifier
                            .padding(8.dp)
                            .clickable {
                                navController.popBackStack()
                            }
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.padding(innerPadding)
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
                modifier
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 8.dp)
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
                    Button(
                        onClick = {
                            val latitude = recipe?.originCoordinates?.latitude
                            val longitude = recipe?.originCoordinates?.longitude
                            navController.navigate("recipe_origin/${latitude}/${longitude}")
                        }
                    ) {
                        Text("See origin in the map")
                    }
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
    }
}