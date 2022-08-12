package com.example.byyou

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Local : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local)

        val bt = findViewById<Button>(R.id.toMed)
        val quad = findViewById<ImageView>(R.id.square)
        val hitbox = findViewById<ImageView>(R.id.tr)
        val textLocal = findViewById<TextView>(R.id.textL)
        hitbox.setOnClickListener{
            bt.visibility = View.VISIBLE
            quad.visibility = View.VISIBLE
            textLocal.visibility = View.VISIBLE
        }

        bt.setOnClickListener{
            irAreas()
        }

    }


    private fun irAreas(){
        val i = Intent(this,Areas::class.java)
        startActivity(i)
    }

}