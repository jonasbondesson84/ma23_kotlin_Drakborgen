package com.example.drakoborgen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import java.io.File

class MainActivity : AppCompatActivity() {

    val charList = mutableListOf<Character>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNewCharacter: Button = findViewById(R.id.btnNewCharacter)
        btnNewCharacter.setOnClickListener() {

            val intent = Intent(this, createCharacterActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()

        try {
            val filePath = this.filesDir.absolutePath + "/characters.json"
            val jsonString = File(filePath).readText()

            val jsonArray = JSONArray(jsonString)

            for(i in 0 until jsonArray.length()) {
                val charJSON = jsonArray.getJSONObject(i)
                val charName = charJSON.getString("name")
                val charLuck = charJSON.getString("luck").toInt()
                val charStrength = charJSON.getString("strength").toInt()
                val charArmor = charJSON.getString("armor").toInt()
                val charAgility = charJSON.getString("agility").toInt()

                charList.add(Character(charName, charLuck, charStrength, charArmor, charAgility))
                val message = "Inläst data: $charName, $charLuck, $charStrength, $charArmor, $charAgility"
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }

        } catch (e: Exception) {
            Toast.makeText(this, "Det gick inte att läsa in filen. Fel: ${e.message}", Toast.LENGTH_SHORT).show()
        }

    }
}