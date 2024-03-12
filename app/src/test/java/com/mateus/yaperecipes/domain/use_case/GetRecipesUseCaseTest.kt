package com.mateus.yaperecipes.domain.use_case

import com.mateus.yaperecipes.data.Resource
import com.mateus.yaperecipes.data.repository.IRecipesRepository
import com.mateus.yaperecipes.domain.model.OriginCoordinates
import com.mateus.yaperecipes.domain.model.Recipe
import com.mateus.yaperecipes.domain.model.Recipes
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doThrow
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetRecipesUseCaseTest {
    @Mock
    private lateinit var recipesRepository: IRecipesRepository
    private lateinit var getRecipesUseCase: GetRecipesUseCase
    private val fakeRecipes = Recipes(
        listOf(
            Recipe(
                id = 1,
                name = "food recipe",
                image = "url",
                ingredients = emptyList(),
                originCoordinates = OriginCoordinates(0.0, 0.0),
                preparationSteps = emptyList()
            )
        )
    )

    @Before
    fun setUp() {
        getRecipesUseCase = GetRecipesUseCase(recipesRepository)
    }
    @Test
    fun `should return loading and then success when getRecipes correctly return data`() = runTest {
        whenever(recipesRepository.getRecipes())
            .thenReturn(fakeRecipes)

        val result = getRecipesUseCase().toList()

        assert(result.size == 2)
        assert(result[0] is Resource.Loading)
        assert(result[1] is Resource.Success)
    }

    @Test
    fun `should return loading and then error when getRecipes throws an error`() = runTest {
        val exception = RuntimeException()
        doThrow(exception).`when`(recipesRepository).getRecipes()

        val result = getRecipesUseCase().toList()

        assert(result[0] is Resource.Loading)
        assert(result[1] is Resource.Error)
    }
}