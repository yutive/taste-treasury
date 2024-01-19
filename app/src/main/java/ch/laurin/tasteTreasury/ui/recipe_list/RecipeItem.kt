package ch.laurin.tasteTreasury.ui.recipe_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ch.laurin.tasteTreasury.data.Recipe

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