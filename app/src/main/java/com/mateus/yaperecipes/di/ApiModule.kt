package com.mateus.yaperecipes.di

import com.mateus.yaperecipes.data.remote.IReceipesApi
import com.mateus.yaperecipes.data.remote.RecipesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Singleton
    @Provides
    fun provideHttpClient() : HttpClient {
        return HttpClient(Android) {
            install(ContentNegotiation) {
                json()
            }
        }
    }

    @Singleton
    @Provides
    fun provideRecipesApi(
        httpClient: HttpClient
    ) : IReceipesApi = RecipesApi(httpClient)
}