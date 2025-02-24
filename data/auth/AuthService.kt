package com.example.indica.data.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

sealed class AuthResult {
    object Loading : AuthResult()
    data class Success(val user: FirebaseUser) : AuthResult()
    data class Error(val message: String, val type: AuthErrorType = AuthErrorType.UNKNOWN) : AuthResult()
}

enum class AuthErrorType {
    INVALID_EMAIL,
    WRONG_PASSWORD,
    USER_NOT_FOUND,
    NETWORK_ERROR,
    UNKNOWN
}

fun getLocalizedErrorMessage(errorType: AuthErrorType): String {
    return when (errorType) {
        AuthErrorType.INVALID_EMAIL -> "E-mail inválido"
        AuthErrorType.WRONG_PASSWORD -> "Senha incorreta"
        AuthErrorType.USER_NOT_FOUND -> "Usuário não encontrado"
        AuthErrorType.NETWORK_ERROR -> "Erro de conexão. Verifique sua internet"
        AuthErrorType.UNKNOWN -> "Ocorreu um erro. Tente novamente mais tarde"
    }
}

interface AuthService {
    val currentUser: FirebaseUser?
    val authState: StateFlow<AuthResult>
    
    suspend fun signIn(email: String, password: String): AuthResult
    suspend fun signOut()
}

@Singleton
class FirebaseAuthService @Inject constructor(
    private val auth: FirebaseAuth
) : AuthService {
    
    private val _authState = MutableStateFlow<AuthResult>(AuthResult.Loading)
    override val authState: StateFlow<AuthResult> = _authState
    
    override val currentUser: FirebaseUser?
        get() = auth.currentUser
    
    override suspend fun signIn(email: String, password: String): AuthResult {
        return try {
            _authState.value = AuthResult.Loading
            val result = auth.signInWithEmailAndPassword(email, password).await()
            val user = result.user
            if (user != null) {
                _authState.value = AuthResult.Success(user)
                AuthResult.Success(user)
            } else {
                _authState.value = AuthResult.Error("Authentication failed")
                AuthResult.Error("Authentication failed")
            }
        } catch (e: Exception) {
            val errorType = when {
                e.message?.contains("invalid email", ignoreCase = true) == true -> AuthErrorType.INVALID_EMAIL
                e.message?.contains("wrong password", ignoreCase = true) == true -> AuthErrorType.WRONG_PASSWORD
                e.message?.contains("no user record", ignoreCase = true) == true -> AuthErrorType.USER_NOT_FOUND
                e.message?.contains("network", ignoreCase = true) == true -> AuthErrorType.NETWORK_ERROR
                else -> AuthErrorType.UNKNOWN
            }
            val errorMessage = getLocalizedErrorMessage(errorType)
            _authState.value = AuthResult.Error(errorMessage, errorType)
            AuthResult.Error(errorMessage, errorType)
        }
    }
    
    override suspend fun signOut() {
        auth.signOut()
        _authState.value = AuthResult.Error("Sessão encerrada", AuthErrorType.UNKNOWN)
    }
}