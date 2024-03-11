package com.mateus.yaperecipes.ui.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
        startDestination = "recipes"
    ) {
        composable("recipes") {
            Recipes(
                recipesViewModel = hiltViewModel<RecipesViewModel>(),
                navController = navController
            )
        }
        composable(
            route = "recipe_details/{recipe}",
            arguments = listOf(navArgument("recipe") { type = NavType.IntType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getInt("recipe")?.let { recipePosition ->
                RecipeDetails(
                    recipesViewModel = hiltViewModel<RecipesViewModel>(),
                    recipeId = recipePosition
                )
            }
        }
    }
}