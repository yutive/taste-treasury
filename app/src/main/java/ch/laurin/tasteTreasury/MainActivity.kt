package ch.laurin.tasteTreasury

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ch.laurin.tasteTreasury.ui.theme.TastetreasuryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TastetreasuryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AddButton(onClick = { Log.d("FAB", "FAB clicked.") })
                }
            }
        }
    }
}

@Composable
fun AddButton(onClick: () -> Unit) {
    LargeFloatingActionButton(
        onClick = { onClick() },
        modifier = Modifier
            .padding(20.dp)
            .wrapContentSize(align = Alignment.BottomEnd)
    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}

@Preview(showBackground = true)
@Composable
fun AddButtonPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        AddButton(onClick = { Log.d("FAB", "FAB clicked.") })
    }
}
