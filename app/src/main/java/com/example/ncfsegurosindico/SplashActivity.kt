package com.example.ncfsegurosindico

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val SPLASH_DELAY: Long = 2000 // 2 segundos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            // Navega para a tela de Login/Cadastro
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Finaliza a SplashActivity para que o usuário não volte para ela ao pressionar o botão "voltar"
        }, SPLASH_DELAY)
    }
} 