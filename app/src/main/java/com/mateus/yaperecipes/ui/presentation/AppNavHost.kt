package com.mateus.yaperecipes.ui.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mateus.yaperecipes.ui.presentation.recipes.RecipeDetails
import com.mateus.yaperecipes.ui.presentation.recipes.Recipes
import com.mateus.yaperecipes.ui.presentation.recipes.RecipesViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = "Recipes"
    ) {
        composable("Recipes") {
            Recipes(
                recipesViewModel = hiltViewModel<RecipesViewModel>(),
                navigateToDetails = {
                    navController.navigate("RecipeDetails")
                }
            )
        }
        composable("RecipeDetails") { RecipeDetails() }
    }
}