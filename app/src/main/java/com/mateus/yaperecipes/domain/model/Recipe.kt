package com.mateus.yaperecipes.domain.model

data class Recipe(
    val name: String,
    val image: String,
    val ingredients: List<String>,
    val origin_coordinates: OriginCoordinates,
    val preparation_steps: List<String>
)