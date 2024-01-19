package ch.laurin.tasteTreasury

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import ch.laurin.tasteTreasury.ui.recipe_list.AddButton
import ch.laurin.tasteTreasury.ui.recipe_list.RecipeList
import ch.laurin.tasteTreasury.ui.recipe_list.RecipeListViewModel
import ch.laurin.tasteTreasury.ui.theme.TastetreasuryTheme


class MainActivity : ComponentActivity() {
    private val recipeListViewModel: RecipeListViewModel by viewModels()
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
    val uiState by recipeListViewModel.uiState.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        RecipeList(uiState.recipes ?: emptyList())
        AddButton()
    }
}


