package ch.laurin.tasteTreasury.ui.recipe_list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ch.laurin.tasteTreasury.data.Recipe

@Composable
fun RecipeList(recipes: List<Recipe>) {
    LazyColumn (
        state = rememberLazyListState(),
        modifier = Modifier.padding(32.dp)
    ){
        items(recipes) {recipe ->
            RecipeListItem(recipe)
        }
    }
}