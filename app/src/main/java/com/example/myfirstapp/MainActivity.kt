package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Di dalam onCreate
        val etUsername: EditText = findViewById(R.id.et_username)
        val btnLogin: Button = findViewById(R.id.btn_login)
        val btnRegister: Button = findViewById(R.id.btn_register)


        btnLogin.setOnClickListener {
            // 1. Mengambil data dari EditText
            val username = etUsername.text.toString()


            // 2. Membuat Intent untuk pindah ke HomeActivity
            val intent = Intent(this, HomeActivity::class.java)


            // 3. Menambahkan data ke Intent
            intent.putExtra("EXTRA_USERNAME", username)


            // 4. Menjalankan Intent
            startActivity(intent)
        }

        btnRegister.setOnClickListener {
            // 1. Membuat Intent untuk pindah ke HomeActivity
            val intent = Intent(this, RegisterActivity::class.java)


            // 2. Menjalankan Intent
            startActivity(intent)
        }

        Log.d("MainActivity", "Aplikasi berhasil dijalankan!")
    }
}