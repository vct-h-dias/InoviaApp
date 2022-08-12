package com.example.byyou

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Infos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infos)

        val btback: Button = findViewById(R.id.back)
        btback.setOnClickListener {
            voltar()
        }


    }
    private fun voltar(){
        val intention = Intent(this,Paciente::class.java)
        startActivity(intention)

    }


}