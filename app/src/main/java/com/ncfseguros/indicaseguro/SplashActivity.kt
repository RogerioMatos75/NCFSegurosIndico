package com.ncfseguros.indicaseguro

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Aqui você pode adicionar um layout de splash se desejar

        // Iniciar LoginActivity
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Finaliza a SplashActivity
    }
} 