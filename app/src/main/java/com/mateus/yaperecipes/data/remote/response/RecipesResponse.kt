package com.mateus.yaperecipes.data.remote.response

import com.mateus.yaperecipes.domain.model.Recipes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipesResponse(
    @SerialName("recipes")
    val recipes: List<RecipeResponse>
)

fun RecipesResponse.toRecipes(): Recipes {
    return Recipes(
        recipes.map { recipeResponse ->
            recipeResponse.toRecipe()
        }
    )
}