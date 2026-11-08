package com.example.proyectopruebatema3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FormularioNuevoUsuario(modifier: Modifier = Modifier) {
    var nombre by rememberSaveable() { mutableStateOf("") }
    var correo by rememberSaveable() { mutableStateOf("") }
    var aceptaCondiciones by rememberSaveable() { mutableStateOf(false) }
    var tiposDeCuenta = listOf("Estandar", "Premium", "Empresa")
    var tipoSeleccionado by rememberSaveable() { mutableStateOf(tiposDeCuenta[0]) }

    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(text = "Nuevo usuario", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it},
            label = { Text("Nombre") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
        )

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it},
            label = { Text("Correo electronico") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth(),
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = aceptaCondiciones,
                onCheckedChange = { aceptaCondiciones = it },
            )
            Text("Acepto las condiciones de uso")
        }

        Text(text = "Tipo de cuenta", style = MaterialTheme.typography.titleMedium)

        Column(modifier = Modifier.selectableGroup()) {
            tiposDeCuenta.forEach { tipo ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (tipo == tipoSeleccionado),
                            onClick = { tipoSeleccionado = tipo },
                            role = Role.RadioButton,
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    RadioButton(
                        selected = (tipo == tipoSeleccionado),
                        onClick = null,
                    )
                    Text(text = tipo, modifier = Modifier.padding(start = 8.dp))
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
        ) {
            TextButton(onClick = { }) { Text("Cancelar") }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { }) { Text("Registrar") }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormularioNuevoUsuarioPreview() {
    FormularioNuevoUsuario()
}