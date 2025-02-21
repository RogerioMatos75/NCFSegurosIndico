package com.example.indica.data.repository

import com.example.indica.domain.models.User
import com.example.indica.domain.repository.UserRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : UserRepository {
    private val currentUserFlow = MutableStateFlow<User?>(null)
    
    override suspend fun getUserById(id: String): User? {
        return try {
            val document = firestore.collection("users").document(id).get().await()
            document.toObject(User::class.java)
        } catch (e: Exception) {
            null
        }
    }
    
    override suspend fun getUserByEmail(email: String): User? {
        return try {
            val query = firestore.collection("users")
                .whereEqualTo("email", email)
                .get()
                .await()
            query.documents.firstOrNull()?.toObject(User::class.java)
        } catch (e: Exception) {
            null
        }
    }
    
    override suspend fun updateUser(user: User): Boolean {
        return try {
            firestore.collection("users").document(user.id)
                .set(user)
                .await()
            currentUserFlow.value = user
            true
        } catch (e: Exception) {
            false
        }
    }
    
    override fun observeCurrentUser(): Flow<User?> = currentUserFlow
}