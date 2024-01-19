package ch.laurin.tasteTreasury.ui.recipe_list// ch.laurin.tasteTreasury.ui.recipe_list.RecipeListViewModel.kt
import androidx.lifecycle.ViewModel
import ch.laurin.tasteTreasury.data.Recipe

class RecipeListViewModel : ViewModel() {
    private val recipes: MutableList<Recipe> = mutableListOf()

    init {
        // Initialize with data
        addRecipe(
            Recipe(
                name = "Recipe 1",
                description = "Description for Recipe 1",
                id = 0
            )
        )

        addRecipe(
            Recipe(
                name = "Recipe 2",
                description = "Description for Recipe 2",
                id = 1
            )
        )
    }

    fun addRecipe(recipe: Recipe) {
        recipes.add(recipe)
    }

    fun getRecipes(): List<Recipe> {
        return recipes.toList()
    }
}
