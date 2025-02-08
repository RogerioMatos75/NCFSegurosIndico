package com.google.ncfsegurosindico.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.ncfsegurosindico.R

/**
 * Tela principal do aplicativo com navegação inferior
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    var selectedItem by remember { mutableStateOf(0) }
    
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(painter = painterResource(R.drawable.ic_home), "Home") },
                    label = { Text("Início") },
                    selected = selectedItem == 0,
                    onClick = { selectedItem = 0 }
                )
                NavigationBarItem(
                    icon = { Icon(painter = painterResource(R.drawable.ic_indicate), "Indicar") },
                    label = { Text("Indicar") },
                    selected = selectedItem == 1,
                    onClick = { selectedItem = 1 }
                )
                NavigationBarItem(
                    icon = { Icon(painter = painterResource(R.drawable.ic_history), "Histórico") },
                    label = { Text("Histórico") },
                    selected = selectedItem == 2,
                    onClick = { selectedItem = 2 }
                )
                NavigationBarItem(
                    icon = { Icon(painter = painterResource(R.drawable.ic_profile), "Perfil") },
                    label = { Text("Perfil") },
                    selected = selectedItem == 3,
                    onClick = { selectedItem = 3 }
                )
            }
        }
    ) { paddingValues ->
        // Conteúdo principal baseado na seleção
        Box(modifier = Modifier.padding(paddingValues)) {
            when (selectedItem) {
                0 -> HomeContent()
                1 -> IndicateContent()
                2 -> HistoryContent()
                3 -> ProfileContent()
            }
        }
    }
}

@Composable
private fun HomeContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Bem-vindo ao NCF Seguros",
            style = MaterialTheme.typography.headlineMedium
        )
        
        // Card de Indicações
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Programa de Indicações",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Indique amigos e ganhe descontos!",
                    style = MaterialTheme.typography.bodyMedium
                )
                Button(
                    onClick = { /* TODO: Navegação para tela de indicação */ },
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text("Indicar Agora")
                }
            }
        }
    }
}

// TODO: Implementar outros conteúdos
@Composable private fun IndicateContent() { /* ... */ }
@Composable private fun HistoryContent() { /* ... */ }
@Composable private fun ProfileContent() { /* ... */ } 