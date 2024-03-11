package com.mateus.yaperecipes.di

import com.mateus.yaperecipes.data.repository.IRecipesRepository
import com.mateus.yaperecipes.data.repository.RecipesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositotyModule {
    @Binds
    fun bindRecipesRepository(
        repository: RecipesRepository
    ) : IRecipesRepository
}