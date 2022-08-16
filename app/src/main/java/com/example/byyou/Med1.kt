package com.example.byyou

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Med1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_med1)

        val btFoto1: Button = findViewById(R.id.toFoto1)
        btFoto1.setOnClickListener{
            abrirFoto1()
        }

        val btMedFt1: Button = findViewById(R.id.toMedFt1)
        btMedFt1.setOnClickListener{
            abrirMeedFt1()
        }

    }

    private fun abrirMeedFt1(){
        val inte = Intent(this,MedFt1::class.java)
        startActivity(inte)
    }

    private fun abrirFoto1(){
        val intentFoto1 = Intent(this,Foto1::class.java)
        startActivity(intentFoto1)
    }

}