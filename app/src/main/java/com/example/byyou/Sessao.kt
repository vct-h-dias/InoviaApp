package com.example.byyou

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Sessao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sessao)

        val br: Button = findViewById(R.id.toLocal)
        br.setOnClickListener{
            irLocal()
        }


    }

    private fun irLocal(){
        val intent2 = Intent(this,Local::class.java)
        startActivity(intent2)
    }

}