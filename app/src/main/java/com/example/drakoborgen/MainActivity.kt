package com.example.drakoborgen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNewCharacter: Button = findViewById(R.id.btnNewCharacter)
        btnNewCharacter.setOnClickListener() {

            val intent = Intent(this, createCharacterActivity::class.java)
            startActivity(intent)
        }

    }
}