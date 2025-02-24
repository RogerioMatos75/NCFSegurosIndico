package com.example.indica.domain.repository

import com.example.indica.domain.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUserById(id: String): User?
    suspend fun getUserByEmail(email: String): User?
    suspend fun updateUser(user: User): Boolean
    fun observeCurrentUser(): Flow<User?>
}