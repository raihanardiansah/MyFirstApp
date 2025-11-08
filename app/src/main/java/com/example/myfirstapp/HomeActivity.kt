package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

//        val dataList = ArrayList<Mahasiswa>()
//        dataList.add(Mahasiswa("Budi", "24.12.0000"))
//        dataList.add(Mahasiswa("Siti", "24.12.1111"))
//        dataList.add(Mahasiswa("Andi", "24.12.2222"))
//        dataList.add(Mahasiswa("Rina", "24.12.3333"))
//
//        val rvMahasiswa: RecyclerView = findViewById(R.id.rv_mahasiswa)
//        rvMahasiswa.layoutManager = GridLayoutManager(this, 2)
//        val adapter = MahasiswaAdapter(dataList)
//        rvMahasiswa.adapter = adapter
//
////        if (savedInstanceState == null) {
////            supportFragmentManager.beginTransaction()
////                .replace(R.id.fragment_container, DashboardFragment())
////                .commit()
////        }
//
//        // Di dalam onCreate
////        val tvWelcomeMessage: TextView = findViewById(R.id.tv_welcome_message)
//
//
//        // Mengambil data username dari Intent
////        val username = intent.getStringExtra("EXTRA_USERNAME")
//
//
//        // Menampilkan data ke TextView
////        tvWelcomeMessage.text = "Selamat Datang, $username!"
//
//        // Buka Situs Web https://amikom.ac.id
//        val btnOpenWebsite: Button = findViewById(R.id.btn_open_website)
//        btnOpenWebsite.setOnClickListener {
//            // 1. Membuat Intent untuk pindah ke Situs Web https://amikom.ac.id
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = android.net.Uri.parse("https://amikom.ac.id")
//
//
//            // 2. Menjalankan Intent
//            startActivity(intent)
//        }

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // 1. Muat Fragment default (Dashboard) saat pertama kali dibuka
        loadFragment(DashboardFragment())

        // 2. Tambahkan listener untuk menangani klik item navigasi
        bottomNav.setOnItemSelectedListener { item ->
            var fragment: Fragment
            when (item.itemId) {
                R.id.nav_dashboard -> {
                    fragment = DashboardFragment()
                    loadFragment(fragment)
                    true // Mengembalikan true menandakan item telah ditangani
                }
                R.id.nav_profile -> {
                    fragment = ProfileFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.nav_settings -> {
                    fragment = SettingsFragment()
                    loadFragment(fragment)
                    true
                }
                else -> false
            }
        }
    }
    // 3. Buat fungsi helper untuk memuat Fragment
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_home, fragment)
            .commit()
    }
}