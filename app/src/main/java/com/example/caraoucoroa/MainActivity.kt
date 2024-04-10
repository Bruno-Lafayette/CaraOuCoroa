package com.example.caraoucoroa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caraoucoroa.ui.theme.CaraOuCoroaTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaraOuCoroaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val (resultado, setResultado) = remember { mutableStateOf("Cara ou Coroa?") }

        when (resultado){
            "Cara ou Coroa?" -> Row {
                Image(
                    painter = painterResource(id = R.drawable.cara),
                    contentDescription = "Moeda de um real",
                    modifier = Modifier.size(148.dp),
                    contentScale = ContentScale.FillWidth
                )
                Image(
                    painter = painterResource(id = R.drawable.coroa),
                    contentDescription = "Moeda de um real",
                    modifier = Modifier.size(148.dp),
                    contentScale = ContentScale.FillWidth
                )
            }
            "Cara" -> Image(
                painter = painterResource(id = R.drawable.cara),
                contentDescription = "Moeda de um real",
                modifier = Modifier.size(148.dp),
                contentScale = ContentScale.FillWidth
            )
            "Coroa" -> Image(
                painter = painterResource(id = R.drawable.coroa),
                contentDescription = "Moeda de um real",
                modifier = Modifier.size(148.dp),
                contentScale = ContentScale.FillWidth
            )
        }

        Text(
            text = resultado,
            modifier = Modifier.padding(16.dp),
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Button(
            onClick = {
                val novoResultado = if (Random.nextBoolean()) "Cara" else "Coroa"
                setResultado(novoResultado)
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Jogar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CaraOuCoroaTheme {
        Greeting()
    }
}