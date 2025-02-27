package com.ncfseguros.indicaseguro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AdminLoginActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)

        // 1. Obter referências aos elementos da UI
        usernameEditText = findViewById(R.id.editTextAdminUsername)
        passwordEditText = findViewById(R.id.editTextAdminPassword)
        loginButton = findViewById(R.id.buttonAdminLogin)

        // 2. Definir OnClickListener para o botão de login
        loginButton.setOnClickListener {
            performAdminLogin()
        }
    }

    private fun performAdminLogin() {
        // 3. Obter usuário e senha dos EditTexts
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        // 4. Validação básica de entrada (verificar se está vazio)
        if (username.isEmpty() || password.isEmpty()) {
            showError("Por favor, insira usuário e senha")
            return // Parar o processamento
        }

        // 5. **Autenticação simulada (substitua por chamada real à API depois!)**
        if (username == "admin" && password == "admin123") { // **Credenciais codificadas - NÃO USE EM PRODUÇÃO!**
            // Sucesso na autenticação
            showSuccess("Login do Administrador bem-sucedido!")
            // TODO: Navegar para a tela do painel do administrador aqui (em etapas futuras)
        } else {
            // Falha na autenticação
            showError("Usuário ou senha inválidos")
        }
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show() // Duração mais longa para sucesso
    }
} 