package com.mateus.yaperecipes.domain.use_case

import com.mateus.yaperecipes.data.Resource
import com.mateus.yaperecipes.domain.model.Recipes
import kotlinx.coroutines.flow.Flow

interface IGetRecipesUseCase {
    operator fun invoke() : Flow<Resource<Recipes>>
}