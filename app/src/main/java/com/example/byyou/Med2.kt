package com.example.byyou

import android.content.Intent
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

        val btMedFt2: Button = findViewById(R.id.toMedFt2)
        btMedFt2.setOnClickListener{
            abrirMeedFt2()
        }


    }

    private fun abrirMeedFt2(){
        val inte = Intent(this,MedFt2::class.java)
        startActivity(inte)
    }

    private fun irFoto2(){
        val Ft2 = Intent(this,Foto2::class.java)
        startActivity(Ft2)

    }

}