package ch.laurin.tasteTreasury

import RecipeManager
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ch.laurin.tasteTreasury.ui.theme.TastetreasuryTheme

class MainActivity : ComponentActivity() {
    private val recipeManager = RecipeManager()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TastetreasuryTheme {
                MainContent(recipeManager = recipeManager)
            }
        }
    }
}

@Composable
fun MainContent(recipeManager: RecipeManager) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        // Sample recipes
        recipeManager.addRecipe(
            Recipe(
                name = "Recipe 1",
                description = "Description for Recipe 1"
            )
        )

        recipeManager.addRecipe(
            Recipe(
                name = "Recipe 2",
                description = "Description for Recipe 2"
            )
        )
        RecipeList(recipes = recipeManager.getRecipes())
        NavigateToAddRecipe()
    }
}

@Composable
fun RecipeList(recipes: MutableList<Recipe>) {
    Column (
        modifier = Modifier.padding(32.dp)
    ){
        recipes.forEach { recipe ->
            RecipeListItem(recipe = recipe)
        }
    }
}

@Composable
fun RecipeListItem(recipe: Recipe) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp,8.dp,0.dp,8.dp)
    ){
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = "Name: ${recipe.name}")
            Text(text = "Description: ${recipe.description}")
        }
    }
}

@Composable
fun NavigateToAddRecipe() {
    val activity = LocalContext.current as Activity
    LargeFloatingActionButton(
        onClick = {
            activity.startActivity(Intent(activity, AddActivity::class.java))
        },
        modifier = Modifier
            .padding(20.dp)
            .wrapContentSize(align = Alignment.BottomEnd)
    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}

@Preview(showBackground = true)
@Composable
fun NavigateToAddRecipePreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

    }
}
