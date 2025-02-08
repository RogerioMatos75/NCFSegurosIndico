package com.google.ncfsegurosindico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.google.ncfsegurosindico.navigation.AppNavigation
import com.google.ncfsegurosindico.ui.theme.NCFSegurosIndicoTheme

/**
 * Atividade principal do aplicativo
 * Responsável por inicializar o tema e a navegação
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NCFSegurosIndicoTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavigation()
                }
            }
        }
    }
}