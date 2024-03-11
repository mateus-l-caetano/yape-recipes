package com.mateus.yaperecipes.data.remote

import android.util.Log
import com.mateus.yaperecipes.data.remote.response.RecipesResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.json.Json

class RecipesApi : IReceipesApi {
    private val baseUrl = "https://dzq3j.wiremockapi.cloud"
    override suspend fun getRecipes() : RecipesResponse {
        return try {
            val response = KtorHttpClient.client.get (
                "$baseUrl/recipes"
            )
            Log.d("aaaaaa", response.body())
            Json.decodeFromString<RecipesResponse>(response.body())
        } catch (error : Exception) {
            Log.d("aaaaaaa", "${error.message.toString()} caused by ${error.cause}")
            RecipesResponse(arrayOf())
        }
    }
}