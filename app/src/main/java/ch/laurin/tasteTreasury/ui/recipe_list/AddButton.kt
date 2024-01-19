package ch.laurin.tasteTreasury.ui.recipe_list

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import ch.laurin.tasteTreasury.AddActivity

@Composable
fun AddButton() {
    val context = LocalContext.current as Activity
    LargeFloatingActionButton(
        onClick = {
            context.startActivity(Intent(context, AddActivity::class.java))
        },
        modifier = Modifier
            .padding(20.dp)
            .wrapContentSize(align = Alignment.BottomEnd)
    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}
