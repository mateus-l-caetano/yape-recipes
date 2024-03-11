package com.mateus.yaperecipes.ui.presentation.recipes

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mateus.yaperecipes.data.Resource
import com.mateus.yaperecipes.domain.model.Recipes
import com.mateus.yaperecipes.domain.use_case.IGetRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
    private val getRecipesUseCase: IGetRecipesUseCase
) : ViewModel() {
    private val _recipes = MutableStateFlow<Resource<Recipes>>(Resource.Loading())
    val recipes = _recipes.asStateFlow()
    init {
        loadRecipes()
    }

    private fun loadRecipes() {
        viewModelScope.launch(Dispatchers.IO) {
            getRecipesUseCase().collect { response ->
                _recipes.value = response
                Log.d("aaaaa", _recipes.value.toString())
            }
        }
    }
}