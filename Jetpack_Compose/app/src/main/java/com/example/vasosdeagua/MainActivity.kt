package com.example.vasosdeagua

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ContadorDeAgua()
                }
            }
        }
    }
}

@Composable
fun ContadorDeAgua() {
    var vasos by remember { mutableStateOf(0) }
    val meta = 8

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Vasos de agua de hoy", fontSize = 22.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "$vasos / $meta", fontSize = 56.sp)

        if (vasos >= meta) {
            Text(text = "¡Meta cumplida!")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row {
            Button(onClick = { if (vasos > 0) vasos-- }) {
                Text("-1")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { vasos++ }) {
                Text("+1")
            }
        }

        TextButton(onClick = { vasos = 0 }) {
            Text("Reiniciar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VistaPrevia() {
    MaterialTheme {
        ContadorDeAgua()
    }
}
