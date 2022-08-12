package com.example.byyou

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Paciente : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paciente)

        val btstart: Button = findViewById(R.id.iniciar)
        btstart.setOnClickListener {
            abrirPassoaPasso()
        }

        val btinfos: Button = findViewById(R.id.info)
        btinfos.setOnClickListener {
            abrirInfos()
        }



    }
    private fun abrirPassoaPasso(){
        val intention = Intent(this,Sessao::class.java)
        startActivity(intention)

    }

    private fun abrirInfos(){
        val intent = Intent(this,Infos::class.java)
        startActivity(intent)

    }


}