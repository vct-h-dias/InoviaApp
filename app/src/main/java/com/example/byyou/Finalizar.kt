package com.example.byyou

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Finalizar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finalizar)

        val end:Button = findViewById(R.id.Concluido)
        end.setOnClickListener{
            Agenda()
        }

    }
    private fun Agenda(){
        val finish = Intent(this,Agenda::class.java)
        startActivity(finish)
    }

}