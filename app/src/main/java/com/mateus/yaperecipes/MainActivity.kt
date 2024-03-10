package com.mateus.yaperecipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mateus.yaperecipes.ui.theme.YapeRecipesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    Greetings(name = "World")
                }
            }
        }
    }
}

@Composable
fun Greetings(name: String, modifier: Modifier = Modifier) {
    Text("Hello $name")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    YapeRecipesTheme {
        Greetings("World")
    }
}