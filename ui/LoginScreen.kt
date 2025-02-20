import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(navController: NavHostController) {
    val viewModel: LoginViewModel = hiltViewModel()
    val loginState = viewModel.loginState.collectAsState(initial = false)

    // Lógica de UI
    Button(onClick = {
        viewModel.login("user", "password") // Exemplo de login
        if (loginState.value) {
            navController.navigate("dashboardFragment")
        }
    }) {
        Text("Ir para Dashboard")
    }
} 