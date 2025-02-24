package com.example.indica.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.indica.data.auth.AuthService
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DashboardState(
    val totalUsers: Int = 0,
    val pendingIndications: Int = 0,
    val approvedIndications: Int = 0,
    val rejectedIndications: Int = 0,
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class AdminDashboardViewModel @Inject constructor(
    private val authService: AuthService,
    private val firestore: FirebaseFirestore
) : ViewModel() {

    private val _dashboardState = MutableStateFlow(DashboardState())
    val dashboardState: StateFlow<DashboardState> = _dashboardState

    init {
        loadDashboardData()
    }

    private fun loadDashboardData() {
        viewModelScope.launch {
            try {
                _dashboardState.value = _dashboardState.value.copy(isLoading = true)

                // Load total users count
                firestore.collection("users").get()
                    .addOnSuccessListener { users ->
                        val totalUsers = users.size()
                        _dashboardState.value = _dashboardState.value.copy(totalUsers = totalUsers)
                    }

                // Load indications counts
                firestore.collection("indications").get()
                    .addOnSuccessListener { indications ->
                        var pending = 0
                        var approved = 0
                        var rejected = 0

                        for (indication in indications) {
                            when (indication.getString("status")) {
                                "pending" -> pending++
                                "approved" -> approved++
                                "rejected" -> rejected++
                            }
                        }

                        _dashboardState.value = _dashboardState.value.copy(
                            pendingIndications = pending,
                            approvedIndications = approved,
                            rejectedIndications = rejected,
                            isLoading = false
                        )
                    }
                    .addOnFailureListener { e ->
                        _dashboardState.value = _dashboardState.value.copy(
                            error = e.message,
                            isLoading = false
                        )
                    }

            } catch (e: Exception) {
                _dashboardState.value = _dashboardState.value.copy(
                    error = e.message,
                    isLoading = false
                )
            }
        }
    }

    fun refreshDashboard() {
        loadDashboardData()
    }

    fun signOut() {
        viewModelScope.launch {
            authService.signOut()
        }
    }
}