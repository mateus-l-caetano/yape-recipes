package com.mateus.yaperecipes.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipesResponse(
    @SerialName("recipes")
    val recipes: Array<Recipe>
)