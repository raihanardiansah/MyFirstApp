package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Di dalam onCreate
        val tvWelcomeMessage: TextView = findViewById(R.id.tv_welcome_message)


        // Mengambil data username dari Intent
        val username = intent.getStringExtra("EXTRA_USERNAME")


        // Menampilkan data ke TextView
        tvWelcomeMessage.text = "Selamat Datang, $username!"

        // Buka Situs Web https://amikom.ac.id
        val btnOpenWebsite: Button = findViewById(R.id.btn_open_website)
        btnOpenWebsite.setOnClickListener {
            // 1. Membuat Intent untuk pindah ke Situs Web https://amikom.ac.id
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = android.net.Uri.parse("https://amikom.ac.id")


            // 2. Menjalankan Intent
            startActivity(intent)
        }
    }
}