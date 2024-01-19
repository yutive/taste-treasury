package ch.laurin.tasteTreasury.ui.recipe_list

import androidx.lifecycle.ViewModel
import ch.laurin.tasteTreasury.data.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class RecipeUiState(
    val recipes: MutableList<Recipe>? = null
)

class RecipeListViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(RecipeUiState())
    val uiState: StateFlow<RecipeUiState> = _uiState.asStateFlow()


    init {
        addRecipe(
            Recipe(
                name = "Recipe 1",
                description = "Description for Recipe 1",
            )
        )

        addRecipe(
            Recipe(
                name = "Recipe 2",
                description = "Description for Recipe 2",
            )
        )
    }

    // Handle business logic
    fun addRecipe(recipe: Recipe) {
        _uiState.update { currentState ->
            val updatedRecipes = currentState.recipes?.toMutableList() ?: mutableListOf()
            updatedRecipes.add(recipe)
            currentState.copy(recipes = updatedRecipes)
        }
    }

}
