package com.example.byyou

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Med2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_med2)


        val toFoto2: Button = findViewById(R.id.toFoto2)
        toFoto2.setOnClickListener{
            irFoto2()
        }
    }

    private fun irFoto2(){
        //foto2

    }

}