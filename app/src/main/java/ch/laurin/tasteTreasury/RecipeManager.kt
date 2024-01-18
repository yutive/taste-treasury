// RecipeManager.kt
import ch.laurin.tasteTreasury.Recipe

class RecipeManager {
    private val recipes: MutableList<Recipe> = mutableListOf()

    fun addRecipe(recipe: Recipe) {
        recipes.add(recipe)
    }

    fun getRecipes(): MutableList<Recipe> {
        return recipes.toMutableList()
    }
}
