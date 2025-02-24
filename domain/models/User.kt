package com.example.indica.domain.models

data class User(
    val id: String,
    val email: String,
    val name: String,
    val role: UserRole
)

enum class UserRole {
    ADMIN,
    USER
}