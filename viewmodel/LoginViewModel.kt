import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.indica.data.auth.AuthResult
import com.example.indica.data.auth.AuthService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authService: AuthService
) : ViewModel() {
    private val _loginState = MutableStateFlow<AuthResult>(AuthResult.Loading)
    val loginState: StateFlow<AuthResult> = _loginState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = AuthResult.Loading
            _loginState.value = authService.signIn(email, password)
        }
    }

    fun signOut() {
        viewModelScope.launch {
            authService.signOut()
        }
    }
}