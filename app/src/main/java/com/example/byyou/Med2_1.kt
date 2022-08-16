package com.example.byyou

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Med2_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_med21)


        val toFoto2_2: Button = findViewById(R.id.toFoto2_2)
        toFoto2_2.setOnClickListener{
            irFoto2()
        }

    }

    private fun irFoto2(){
        val Ft22 = Intent(this,Foto2::class.java)
        startActivity(Ft22)

    }

}