package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { CompraEntradas() }
    }
}

@Composable
fun CompraEntradas() {
    val precioEntrada = 15
    val precioCanchita = 8
    val precioBebida = 5
    val descuentoCupon = 10

    var cantidad by remember { mutableStateOf(2) }
    var canchita by remember { mutableStateOf(false) }
    var bebida   by remember { mutableStateOf(false) }
    var cupon    by remember { mutableStateOf(false) }

    val subtotal  = cantidad * precioEntrada +
                    (if (canchita) precioCanchita else 0) +
                    (if (bebida)   precioBebida   else 0)
    val descuento = if (cupon) descuentoCupon else 0
    val total     = subtotal - descuento

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Compra de Entradas", style = MaterialTheme.typography.headlineSmall)

        HorizontalDivider()

        // --- Cantidad ---
        Text("Cantidad de Entradas", style = MaterialTheme.typography.titleMedium)
        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedIconButton(onClick = { if (cantidad > 1) cantidad-- }) {
                Text("-")
            }
            Text(
                "$cantidad",
                modifier = Modifier.padding(horizontal = 20.dp),
                style = MaterialTheme.typography.titleLarge
            )
            OutlinedIconButton(onClick = { cantidad++ }) {
                Text("+")
            }
        }

        HorizontalDivider()

        // --- Extras ---
        Text("Extras", style = MaterialTheme.typography.titleMedium)
        LabeledCheckbox("Canchita  +\$$precioCanchita", canchita) { canchita = it }
        LabeledCheckbox("Bebida  +\$$precioBebida",      bebida)   { bebida   = it }

        HorizontalDivider()

        // --- Cupón ---
        LabeledCheckbox("Aplicar cupón  -\$$descuentoCupon", cupon) { cupon = it }

        HorizontalDivider()

        // --- Resumen ---
        Text("Subtotal:   \$$subtotal")
        Text("Descuento:  \$$descuento")
        Text("Total:      \$$total", style = MaterialTheme.typography.titleMedium)

        Spacer(Modifier.height(8.dp))

        Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
            Text("Comprar")
        }
    }
}

@Composable
fun LabeledCheckbox(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        Text(label)
    }
}