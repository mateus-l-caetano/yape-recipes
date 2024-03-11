package com.mateus.yaperecipes.domain.use_case

import com.mateus.yaperecipes.data.Resource
import com.mateus.yaperecipes.data.repository.IRecipesRepository
import com.mateus.yaperecipes.domain.model.Recipes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(
    private val recipesRepository: IRecipesRepository
) : IGetRecipesUseCase {
    override fun invoke(): Flow<Resource<Recipes>> = flow {
        emit(Resource.Loading())
        try {
            val recipes = recipesRepository.getRecipes()
            emit(Resource.Success(recipes))
        } catch (e : Exception) {
            emit(
                Resource.Error(e.message ?: "Error when getting recipes")
            )
        }
    }
}