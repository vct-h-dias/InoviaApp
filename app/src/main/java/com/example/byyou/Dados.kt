package com.example.byyou

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Dados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dados)

        val toMed2: Button = findViewById(R.id.toMed2)
        toMed2.setOnClickListener{
            abrirMed2()
        }


    }

    private fun abrirMed2(){
        val aMed2 = Intent(this,Med2::class.java)
        startActivity(aMed2)
    }



}