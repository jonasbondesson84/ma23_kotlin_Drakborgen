package com.example.drakoborgen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import org.json.JSONObject
import java.io.File

class createCharacterActivity : AppCompatActivity() {

    lateinit var luckNumber: TextView
    lateinit var strengthNumber: TextView
    lateinit var armorNumber: TextView
    lateinit var agilityNumber: TextView
    lateinit var totalNumber: TextView
    lateinit var nameEditText: EditText

    val charList = mutableListOf<Character>()
    var luck: Int = 5
    var strength: Int = 5
    var armor: Int = 5
    var agility: Int = 5
    var total: Int = luck + strength + armor + agility

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_character)

        luckNumber = findViewById(R.id.luckNumber)
        strengthNumber = findViewById(R.id.strengthNumber)
        armorNumber = findViewById(R.id.armorNumber)
        agilityNumber = findViewById(R.id.agilityNumber)
        totalNumber = findViewById(R.id.totalNumber)
        nameEditText = findViewById(R.id.enterNameView)

        totalNumber.text = getString(R.string.total, total.toString())

        val btnAddLuck: ImageButton = findViewById(R.id.luckAdd)
        val btnRemoveLuck: ImageButton = findViewById(R.id.luckRemove)
        val btnAddStrength: ImageButton = findViewById(R.id.strengthAdd)
        val btnRemoveStrength: ImageButton = findViewById(R.id.strengthRemove)
        val btnAddArmor: ImageButton = findViewById(R.id.armorAdd)
        val btnRemoveArmor: ImageButton = findViewById(R.id.armorRemove)
        val btnAddAgility: ImageButton = findViewById(R.id.agilityAdd)
        val btnRemoveAgility: ImageButton = findViewById(R.id.agilityRemove)

        val btnSave: Button = findViewById(R.id.saveButton)


        btnAddLuck.setOnClickListener() {
            if(luck < 11 && total < 31) {
                addValue("luck")
            }
        }
        btnRemoveLuck.setOnClickListener() {
            if(luck > 5) {
                removeValue("luck")
            }
        }
        btnAddStrength.setOnClickListener() {
            if(strength < 11 && total < 31) {
                addValue("strength")
            }
        }
        btnRemoveStrength.setOnClickListener() {
            if(strength > 5) {
                removeValue("strength")
            }
        }
        btnAddArmor.setOnClickListener() {
            if(armor < 11 && total < 31) {
                addValue("armor")
            }
        }
        btnRemoveArmor.setOnClickListener() {
            if(armor > 5) {
                removeValue("armor")
            }
        }
        btnAddAgility.setOnClickListener() {
            if(agility < 11 && total < 31) {
                addValue("agility")
            }
        }
        btnRemoveAgility.setOnClickListener() {
            if(agility > 5) {
                removeValue("agility")
            }
        }

        btnSave.setOnClickListener() {
            SaveCharacter()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }


    }


    fun SaveCharacter() {
        val newCharacter = Character(nameEditText.text.toString(), luck, strength, armor, agility)
        val json = JSONObject()
        json.put("name", newCharacter.name)
        json.put("luck", newCharacter.luck)
        json.put("strength", newCharacter.strength)
        json.put("armor", newCharacter.armor)
        json.put("agility", newCharacter.agility)
        charList.add(newCharacter)

        val jsonList = JSONArray()

        charList.forEach() {character ->
            val charJSON = JSONObject()
            charJSON.put("name", character.name)
            charJSON.put("luck", character.luck)
            charJSON.put("strength", character.strength)
            charJSON.put("armor", character.armor)
            charJSON.put("agility", character.agility)

            jsonList.put(charJSON)
        }

        try {
            val filePath = this.filesDir.absolutePath + "/characters.json"
            File(filePath).writeText(jsonList.toString())
            Toast.makeText(this, "Det funkade ${this.filesDir}", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Det funkade ej. Fel: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
    fun addValue(attribute: String) {
        when (attribute) {
            "luck" -> {
                luck++
                luckNumber.text = luck.toString()
                total++
            }

            "strength" -> {
                strength++
                strengthNumber.text = strength.toString()
                total++
            }

            "armor" -> {
                armor++
                armorNumber.text = armor.toString()
                total++
            }

            "agility" -> {
                agility++
                agilityNumber.text = agility.toString()
                total++
            }
        }
        totalNumber.text = getString(R.string.total, total.toString())
    }

    fun removeValue(attribute: String) {
        when (attribute) {
            "luck" -> {
                luck--
                luckNumber.text = luck.toString()
                total--
            }

            "strength" -> {
                strength--
                strengthNumber.text = strength.toString()
                total--
            }

            "armor" -> {
                armor--
                armorNumber.text = armor.toString()
                total--
            }

            "agility" -> {
                agility--
                armorNumber.text = agility.toString()
                total--
            }
        }
        totalNumber.text = getString(R.string.total, total.toString())
    }
}