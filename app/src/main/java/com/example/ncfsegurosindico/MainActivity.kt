package com.example.ncfsegurosindico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var isDrawerOpen by remember { mutableStateOf(false) }

    PermanentNavigationDrawer(
        drawerContent = {
            PermanentDrawerSheet(modifier = Modifier.width(240.dp)) {
                Spacer(Modifier.height(12.dp))
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Indicação") },
                    label = { Text("Indicação") },
                    selected = false,
                    onClick = { /* Handle click */ },
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.AttachMoney, contentDescription = "Desconto") },
                    label = { Text("Desconto") },
                    selected = false,
                    onClick = { /* Handle click */ },
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.DirectionsCar, contentDescription = "Apólice do Cliente") },
                    label = { Text("Apólice do Cliente") },
                    selected = false,
                    onClick = { /* Handle click */ },
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("NCF Seguros Indico") },
                    colors = TopAppBarDefaults.topAppBarColors()
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                // Banner Section
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    shadowElevation = 4.dp
                ) {
                    // TODO: Implement banner carousel
                    Text(
                        text = "Banner Area",
                        modifier = Modifier.fillMaxSize(),
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // News Feed Section
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    shadowElevation = 4.dp
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Notícias sobre Seguros",
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        // TODO: Implement news feed
                        Text(
                            text = "Aqui serão exibidas as últimas notícias e atualizações sobre seguros.",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}