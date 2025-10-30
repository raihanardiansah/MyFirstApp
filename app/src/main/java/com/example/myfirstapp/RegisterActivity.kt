package com.example.myfirstapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inisialisasi komponen
        val rgGender: RadioGroup = findViewById(R.id.rg_gender)
        val cbAgreement: CheckBox = findViewById(R.id.cb_agreement)
        val btnSubmit: Button = findViewById(R.id.btn_submit_register)

        btnSubmit.setOnClickListener {
            val selectedGenderId = rgGender.checkedRadioButtonId
            var gender = ""
            val spinnerCity: Spinner = findViewById(R.id.spinner_domisili)
            val selectedCity = spinnerCity.selectedItem.toString()

            when (selectedGenderId) {
                R.id.rb_pria -> gender = "Pria"
                R.id.rb_wanita -> gender = "Wanita"
                else -> gender = "Belum dipilih"
            }

            val isAgreed = cbAgreement.isChecked

            Toast.makeText(
                this,"Jenis Kelamin: $gender, Kota: $selectedCity, Setuju: $isAgreed", Toast.LENGTH_SHORT
            ).show()

        }
    }
}