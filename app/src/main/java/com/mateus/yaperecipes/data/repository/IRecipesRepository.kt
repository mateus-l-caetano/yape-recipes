package com.mateus.yaperecipes.data.repository

import com.mateus.yaperecipes.domain.model.Recipes

interface IRecipesRepository {
    suspend fun getRecipes() : Recipes
}