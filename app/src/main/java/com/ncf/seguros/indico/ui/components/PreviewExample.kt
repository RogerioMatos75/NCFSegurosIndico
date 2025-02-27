package com.ncf.seguros.indico.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WelcomeScreen(name: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Bem-vindo ao")
        Text(text = "NCF Seguros Indico")
        Text(text = "Olá, $name!")
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(name = "Usuário")
}