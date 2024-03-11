package com.mateus.yaperecipes.di

import com.mateus.yaperecipes.domain.use_case.GetRecipesUseCase
import com.mateus.yaperecipes.domain.use_case.IGetRecipesUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {
    @Binds
    fun bindGetRecipesUseCase(
        getRecipesUseCase: GetRecipesUseCase
    ) : IGetRecipesUseCase
}