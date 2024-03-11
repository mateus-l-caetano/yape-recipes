package com.mateus.yaperecipes.data.repository

import android.util.Log
import com.mateus.yaperecipes.data.remote.IReceipesApi
import com.mateus.yaperecipes.data.remote.response.toRecipe
import com.mateus.yaperecipes.domain.model.Recipes
import javax.inject.Inject

class RecipesRepository @Inject constructor(
    private val recipesApi: IReceipesApi
) : IRecipesRepository {
    override suspend fun getRecipes(): Recipes {
        val recipesResponse = recipesApi.getRecipes()
        val recipesList = recipesResponse.recipes.map { recipeResponse ->
            Log.d("aaaaaa", recipeResponse.name)
            recipeResponse.toRecipe()
        }
        return Recipes(recipesList)
    }
}