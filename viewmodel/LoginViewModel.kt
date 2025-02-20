import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel : ViewModel() {
    private val _loginState = MutableStateFlow(false)
    val loginState: StateFlow<Boolean> get() = _loginState

    fun login(username: String, password: String) {
        // Lógica de autenticação (exemplo simplificado)
        if (username == "user" && password == "password") {
            _loginState.value = true // Login bem-sucedido
        } else {
            _loginState.value = false // Falha no login
        }
    }
} 