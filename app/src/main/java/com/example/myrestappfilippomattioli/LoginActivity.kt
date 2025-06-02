package com.example.myrestappfilippomattioli

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val username = findViewById<EditText>(R.id.editUsername)
        val password = findViewById<EditText>(R.id.editPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)
        loginButton.setOnClickListener {
            val user = username.text.toString()
            val pass = password.text.toString()

              if (user == "abbonato" && pass == "password") {
                  val intent = Intent(this, MenuActivity::class.java)
                  startActivity(intent)
                  finish()
              } else {
        Toast.makeText(this, "Credenziali non valide", Toast.LENGTH_SHORT).show()
            }
        }
    }
}