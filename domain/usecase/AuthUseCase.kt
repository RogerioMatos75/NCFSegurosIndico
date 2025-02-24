package com.example.indica.domain.usecase

import com.example.indica.data.auth.AuthResult
import com.example.indica.data.auth.AuthService
import com.example.indica.domain.models.User
import com.example.indica.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val authService: AuthService,
    private val userRepository: UserRepository
) {
    suspend fun signIn(email: String, password: String): AuthResult {
        return authService.signIn(email, password)
    }

    suspend fun signOut() {
        authService.signOut()
    }

    fun observeAuthenticatedUser(): Flow<User?> {
        return userRepository.observeCurrentUser()
    }

    val isUserAuthenticated: Boolean
        get() = authService.currentUser != null
}