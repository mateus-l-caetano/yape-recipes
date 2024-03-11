package com.mateus.yaperecipes.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Recipe(
    val id: Int,
    val name: String,
    val image: String,
    val ingredients: List<String>,
    val originCoordinates: OriginCoordinates,
    val preparationSteps: List<String>
)