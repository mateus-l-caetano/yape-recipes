package com.mateus.yaperecipes.data.remote.response


import com.mateus.yaperecipes.domain.model.Recipe
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeResponse(
    @SerialName("image")
    val image: String,
    @SerialName("ingredients")
    val ingredients: List<String>,
    @SerialName("name")
    val name: String,
    @SerialName("origin_coordinates")
    val originCoordinates: OriginCoordinatesResponse,
    @SerialName("preparation_steps")
    val preparationSteps: List<String>
)

fun RecipeResponse.toRecipe() =
    Recipe(
        name,
        image,
        ingredients,
        originCoordinates.toOriginCoordinates(),
        preparationSteps
    )