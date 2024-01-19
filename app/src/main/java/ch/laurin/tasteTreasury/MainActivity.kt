package ch.laurin.tasteTreasury

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import ch.laurin.tasteTreasury.data.Recipe
import ch.laurin.tasteTreasury.ui.recipe_list.AddButton
import ch.laurin.tasteTreasury.ui.recipe_list.RecipeList
import ch.laurin.tasteTreasury.ui.recipe_list.RecipeListViewModel
import ch.laurin.tasteTreasury.ui.theme.TastetreasuryTheme

class MainActivity : ComponentActivity() {

    private val recipeListViewModel = RecipeListViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TastetreasuryTheme {
                MainContent(recipeListViewModel = recipeListViewModel)
            }
        }
    }
}

@Composable
fun MainContent(recipeListViewModel: RecipeListViewModel) {
    var recipes by remember { mutableStateOf(emptyList<Recipe>()) }

    LaunchedEffect(recipeListViewModel) {
        recipes = recipeListViewModel.getRecipes()
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        RecipeList(recipes = recipes)
        AddButton()
    }
}

