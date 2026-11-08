package com.example.proyectopruebatema3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


data class Resena(
    val nombre: String,
    val comentario: String,
    val valoracion: Int,
)

val resenas = listOf(
    Resena(nombre = "Ana", comentario = "Muy bien", valoracion = 10),
    Resena(nombre = "Luís", comentario = "Bien", valoracion = 7),
    Resena(nombre = "Marta", comentario = "Normal", valoracion = 5),
    Resena(nombre = "Pablo", comentario = "Mal", valoracion = 1)
)

@Composable
fun FilaResenya(
    nombre: String,
    comentario: String,
    valoracion: Int,
    modifier: Modifier = Modifier,
) {
    val iniciales = nombre.split(" ")
        .mapNotNull { it.firstOrNull() }
        .take(2)
        .joinToString("")

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF2F6BFF)),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = iniciales, color = Color.White, fontWeight = FontWeight.Bold)
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(text = nombre, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = comentario,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }

            Icon(
               painter = painterResource(R.drawable.ic_star_outline),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
            )

            Text(text = "$valoracion ★", style = MaterialTheme.typography.titleSmall)
        }
    }


}

@Preview (showBackground = true)
@Composable
fun ListaResenyas(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        resenas.forEach { resena ->
            FilaResenya(
                nombre = resena.nombre,
                comentario = resena.comentario,
                valoracion = resena.valoracion
            )
        }
    }
}


