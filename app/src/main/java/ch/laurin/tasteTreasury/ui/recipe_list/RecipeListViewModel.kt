package ch.laurin.tasteTreasury.ui.recipe_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ch.laurin.tasteTreasury.data.Recipe

class RecipeListViewModel : ViewModel() {

    private val _recipes = MutableLiveData<List<Recipe>>()
    val recipes: LiveData<List<Recipe>> get() = _recipes

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

    fun addRecipe(recipe: Recipe) {
        _recipes.value = _recipes.value.orEmpty() + recipe
    }
}
