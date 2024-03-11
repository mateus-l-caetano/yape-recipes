package com.mateus.yaperecipes.ui.presentation.recipes

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mateus.yaperecipes.data.Resource
import com.mateus.yaperecipes.domain.model.Recipe
import com.mateus.yaperecipes.ui.theme.YapeRecipesTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Recipes(
    recipesViewModel: RecipesViewModel,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Recipes",
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            )
        }
    ) { innerPadding ->
        val recipes by recipesViewModel.recipes.collectAsStateWithLifecycle()

        when(recipes) {
            is Resource.Error -> {
                Log.d("aaaaaa", recipes.toString())
                Box(
                    Modifier.padding(innerPadding).fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column {
                        Text(text = "An error occurred")
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "Try again")
                        }
                    }
                }
            }
            is Resource.Loading -> {
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is Resource.Success -> {
                val recipes = recipes.data?.recipes.orEmpty()
                Column {
                    Box(Modifier.padding(innerPadding))
                    RecipesList(recipes, Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
private fun RecipesList(
    recipes: List<Recipe>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(recipes) { recipe ->
            Column {
                RecipeCard(
                    title = recipe.name,
                    imageUrl = recipe.image
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipesPreview() {
    YapeRecipesTheme {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}