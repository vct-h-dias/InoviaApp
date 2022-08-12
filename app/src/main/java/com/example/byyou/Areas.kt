package com.example.byyou

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Areas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_areas)

        val btMed: Button = findViewById(R.id.toMedFoto1)
        btMed.setOnClickListener{
            irMedicoes()
        }

    }

    private fun irMedicoes(){
        val intentMed = Intent(this,Med1::class.java)
        startActivity(intentMed)
    }

}