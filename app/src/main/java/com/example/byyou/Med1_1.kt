package com.example.byyou

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Med1_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_med11)

        val btFoto1_2: Button = findViewById(R.id.toFoto1_2)
        btFoto1_2.setOnClickListener{
            abrirFoto1()
        }


    }

    private fun abrirFoto1(){
        val intentFoto1 = Intent(this,Foto1::class.java)
        startActivity(intentFoto1)
    }

}