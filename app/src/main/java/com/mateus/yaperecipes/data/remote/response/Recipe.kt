package com.mateus.yaperecipes.data.remote.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Recipe(
    @SerialName("image")
    val image: String,
    @SerialName("ingredients")
    val ingredients: Array<String>,
    @SerialName("name")
    val name: String,
    @SerialName("origin_coordinates")
    val originCoordinates: OriginCoordinates,
    @SerialName("preparation_steps")
    val preparationSteps: Array<String>
)