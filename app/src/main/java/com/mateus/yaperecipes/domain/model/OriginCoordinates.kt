package com.mateus.yaperecipes.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class OriginCoordinates(
    val latitude: Double,
    val longitude: Double
)