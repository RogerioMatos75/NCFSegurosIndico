package com.example.ncfsegurosindico

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    private lateinit var nomeEditText: EditText
    private lateinit var celularEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var enviarButton: Button
    private lateinit var descontosButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Inicializa as views
        nomeEditText = findViewById(R.id.nomeEditText)
        celularEditText = findViewById(R.id.celularEditText)
        emailEditText = findViewById(R.id.emailEditText)
        enviarButton = findViewById(R.id.enviarButton)
        descontosButton = findViewById(R.id.descontosButton)

        // Define o listener do botão "Enviar Indicação"
        enviarButton.setOnClickListener {
            val nome = nomeEditText.text.toString()
            val celular = celularEditText.text.toString()
            val email = emailEditText.text.toString()

            // Valida os campos
            if (nome.isEmpty() || celular.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Envia os dados da indicação por e-mail
            enviarEmail(nome, celular, email)

            // TODO: Armazena os dados da indicação para futuros acessos (usar Room)

            // Limpa os campos
            nomeEditText.text.clear()
            celularEditText.text.clear()
            emailEditText.text.clear()

            Toast.makeText(this, "Indicação enviada com sucesso!", Toast.LENGTH_SHORT).show()
        }

        // Define o listener do botão "Visualizar Descontos"
        descontosButton.setOnClickListener {
            // Navega para a tela de Descontos
            val intent = Intent(this, DescontosActivity::class.java)
            startActivity(intent)
        }
    }

    private fun enviarEmail(nome: String, celular: String, email: String) {
        val recipient = "regina@ncfseguros.com.br"
        val subject = "Nova Indicação de Seguro"
        val message = "Nome: $nome\nCelular: $celular\nEmail: $email"

        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, message)
        }

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Nenhum aplicativo de email encontrado", Toast.LENGTH_SHORT).show()
        }
    }
} 