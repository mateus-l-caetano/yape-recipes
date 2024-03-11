package com.mateus.yaperecipes.data.remote.response


import com.mateus.yaperecipes.domain.model.OriginCoordinates
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OriginCoordinatesResponse(
    @SerialName("latitude")
    val latitude: Double,
    @SerialName("longitude")
    val longitude: Double
)

fun OriginCoordinatesResponse.toOriginCoordinates() =
    OriginCoordinates(
        latitude, longitude
    )