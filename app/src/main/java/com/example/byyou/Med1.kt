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

    }

    private fun abrirFoto1(){
        val intentFoto1 = Intent(this,Foto1::class.java)
        startActivity(intentFoto1)
    }

}