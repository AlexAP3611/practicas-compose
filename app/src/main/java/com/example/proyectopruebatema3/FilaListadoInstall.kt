package com.example.proyectopruebatema3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items

data class AppInfo(
    val nombre: String,
    val categoria: String,
    val valoracion: Double
)

private val categorias = listOf("Strategy", "Action", "Puzzle")
private val valoraciones = listOf(4.8, 4.5, 4.2, 3.9, 4.6)

val apps = List(30) { indice ->
    AppInfo(
        nombre = "App ${indice + 1}",
        categoria = categorias[indice % categorias.size],
        valoracion = valoraciones[indice % valoraciones.size],
    )
}

@Composable
fun FilaListadoInstall(
    nombre: String,
    categoria: String,
    valoracion: Double,
    modifier: Modifier = Modifier,
    onInstall: () -> Unit = {},
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = nombre.take(1), fontWeight = FontWeight.Bold)
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(text = nombre, style = MaterialTheme.typography.titleMedium)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(
                        text = categoria,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .border(
                                1.dp,
                                MaterialTheme.colorScheme.outlineVariant,
                                RoundedCornerShape(50),
                            )
                            .padding(horizontal = 10.dp, vertical = 4.dp),
                    )
                    Text(
                        text = "$valoracion ★",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }
            Button(
                onClick = onInstall,
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2F6BFF),
                    contentColor = Color.White,
                ),
            ) {
                Text(text = "Install", fontWeight = FontWeight.Bold)
            }
        }
    }
}
@Composable
fun ListadoApps(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(apps) { app ->
            FilaListadoInstall(
                nombre = app.nombre,
                categoria = app.categoria,
                valoracion = app.valoracion,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FilaListadoInstallPreview() {
    FilaListadoInstall(nombre = "Orbit Command", categoria = "Strategy", valoracion = 4.8)
}