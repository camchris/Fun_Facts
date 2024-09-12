package com.example.funfacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfacts.ui.theme.FunFactsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FunFactsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RandomFact(
                        modifier = Modifier
                            .padding(innerPadding) // Applies the inner padding provided by Scaffold
                            .padding(20.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun RandomFact(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val quotes = listOf(
            "As goslings, ducks and geese will bond with the first suitable moving stimulus, no matter if this is a goose, person or even an object. They remain dedicated to that person or object as their surrogate 'parent' throughout their lives.",
            "Goose is the term for female geese, male geese are called ganders. A group of geese on land or in water are a gaggle, while in the air they are called a skein.",
            "Geese are very loyal. They mate for life and are protective of their partners and offspring.",
            "Geese have strong affections for others in their group. If a goose gets sick or is wounded, a couple of other geese may drop out of formation to help and protect him.",
            "Geese are good 'guard dogs', they are used to guard prisons in Brazil because of their excellent hearing and ability to see well during night.",
            "Ducks sleep with half of their brain still awake, with their head tucked under a wing and one eye open.",
            "Ducks tend to eat in the water and sleep on land, while geese eat on land and sleep in the water.",
            "Wild Canadian geese can live up to 25 years old.",
            "Geese have serrated tongues.",
            "Geese often swap goslings between families.",
            "At only one day old, goslings can dive 30 to 40 feet underwater.",
            "Geese can fly up to 40 miles per hour.",
            "There are about 30 species of geese worldwide."
        )
        var current by remember { mutableStateOf(quotes.random()) }
        Text(
            text = current,
            modifier = modifier,
            style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp,
                color = Color(0, 51, 102),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        )
        Button(
            onClick = {
                current = quotes.random()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(255, 128, 0), // Background color of the button
                contentColor = Color.White // Color of the button text
            ),

            ) {
            Text(
                text = "Next Fact",
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FunFactsTheme {
        RandomFact()
    }
}