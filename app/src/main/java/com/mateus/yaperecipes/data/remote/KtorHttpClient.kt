package com.mateus.yaperecipes.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

class KtorHttpClient {
    companion object httpClient {
        val client = HttpClient(Android) {
            install(ContentNegotiation) {
                json()
            }
        }
    }
}
