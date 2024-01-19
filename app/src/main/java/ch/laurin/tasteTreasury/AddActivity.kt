package ch.laurin.tasteTreasury

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import ch.laurin.tasteTreasury.data.Recipe
import ch.laurin.tasteTreasury.ui.recipe_add.RecipeDescriptionTextField
import ch.laurin.tasteTreasury.ui.recipe_add.RecipeNameTextField
import ch.laurin.tasteTreasury.ui.recipe_add.SaveRecipeButton
import ch.laurin.tasteTreasury.ui.recipe_add.TakePictureButton
import ch.laurin.tasteTreasury.ui.recipe_list.RecipeListViewModel
import ch.laurin.tasteTreasury.ui.theme.TastetreasuryTheme
import kotlinx.coroutines.launch

class AddActivity : ComponentActivity() {

    private val recipeListViewModel: RecipeListViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TastetreasuryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RecipeFormWithButton(recipeListViewModel)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RecipeFormWithButton(recipeViewModel: RecipeListViewModel) {
    val context = LocalContext.current as Activity
    var nameText by remember { mutableStateOf("") }
    var descriptionText by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        RecipeNameTextField(nameText) { nameText = it }

        Spacer(modifier = Modifier.height(16.dp))
        RecipeDescriptionTextField(descriptionText) { descriptionText = it }

        Spacer(modifier = Modifier.height(16.dp))
        TakePictureButton {
            coroutineScope.launch {
                onTakePictureClicked(recipeViewModel, nameText, descriptionText, vibrator, context)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        SaveRecipeButton {
            coroutineScope.launch {
                onSaveRecipeClicked(recipeViewModel, nameText, descriptionText, vibrator, context)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun onTakePictureClicked(
    recipeViewModel: RecipeListViewModel,
    name: String,
    description: String,
    vibrator: Vibrator,
    context: Context
) {
    recipeViewModel.addRecipe(Recipe(name = name, description = description))
    val timing = 50L
    vibrator.vibrate(VibrationEffect.createOneShot(timing, VibrationEffect.DEFAULT_AMPLITUDE))
    context.startActivity(Intent(context, CameraActivity::class.java))
}

@RequiresApi(Build.VERSION_CODES.O)
private fun onSaveRecipeClicked(
    recipeViewModel: RecipeListViewModel,
    name: String,
    description: String,
    vibrator: Vibrator,
    context: Context
) {
    recipeViewModel.addRecipe(Recipe(name = name, description = description))
    val timing = 50L
    vibrator.vibrate(VibrationEffect.createOneShot(timing, VibrationEffect.DEFAULT_AMPLITUDE))
    (context as? Activity)?.finish()
}

