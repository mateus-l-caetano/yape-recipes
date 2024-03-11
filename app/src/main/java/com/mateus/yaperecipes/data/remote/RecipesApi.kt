package com.mateus.yaperecipes.data.remote

import com.mateus.yaperecipes.data.remote.response.RecipesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.json.Json
import javax.inject.Inject

class RecipesApi @Inject constructor(
    private val httpClient: HttpClient
) : IReceipesApi {
    private val baseUrl = "https://dzq3j.wiremockapi.cloud"
    override suspend fun getRecipes() : RecipesResponse {
        return try {
            val response = httpClient.get (
                "$baseUrl/recipes"
            )
            Json.decodeFromString<RecipesResponse>(response.body())
        } catch (error : Exception) {
            RecipesResponse(listOf())
        }
    }
}