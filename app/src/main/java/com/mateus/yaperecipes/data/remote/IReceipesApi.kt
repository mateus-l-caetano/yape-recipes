package com.mateus.yaperecipes.data.remote

import com.mateus.yaperecipes.data.remote.response.RecipesResponse

interface IReceipesApi {
    suspend fun getRecipes() : RecipesResponse
}