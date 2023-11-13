package com.example.drakoborgen

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class createCharacterActivity : AppCompatActivity() {

    lateinit var luckNumber: TextView
    lateinit var strengthNumber: TextView
    lateinit var armorNumber: TextView
    lateinit var agilityNumber: TextView
    lateinit var totalNumber: TextView
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

        totalNumber.text = getString(R.string.total, total.toString())

        val btnAddLuck: ImageButton = findViewById(R.id.luckAdd)
        val btnRemoveLuck: ImageButton = findViewById(R.id.luckRemove)
        val btnAddStrength: ImageButton = findViewById(R.id.strengthAdd)
        val btnRemoveStrength: ImageButton = findViewById(R.id.strengthRemove)
        val btnAddArmor: ImageButton = findViewById(R.id.armorAdd)
        val btnRemoveArmor: ImageButton = findViewById(R.id.armorRemove)
        val btnAddAgility: ImageButton = findViewById(R.id.agilityAdd)
        val btnRemoveAgility: ImageButton = findViewById(R.id.agilityRemove)


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