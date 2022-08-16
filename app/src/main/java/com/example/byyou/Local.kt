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


        val hitbox = findViewById<ImageView>(R.id.tr)
        val hitbox2 = findViewById<ImageView>(R.id.tr2)


        hitbox.setOnClickListener{

            VisibilidadeA()

        }
        hitbox2.setOnClickListener{

            VisibilidadeC()

        }


        val bt = findViewById<Button>(R.id.toMed)


        bt.setOnClickListener{
            irAreas()
        }

    }


    private fun VisibilidadeA(){
        val bt1 = findViewById<Button>(R.id.toMed)
        bt1.visibility = View.VISIBLE

        val quad = findViewById<ImageView>(R.id.square)
        quad.visibility = View.VISIBLE

        val textLocal = findViewById<TextView>(R.id.textL)
        textLocal.visibility = View.VISIBLE
    }


    private fun VisibilidadeC(){
        val bt2 = findViewById<Button>(R.id.toMed)
        bt2.visibility = View.VISIBLE

        val quad2 = findViewById<ImageView>(R.id.squareC)
        quad2.visibility = View.VISIBLE

        val textLocalC = findViewById<TextView>(R.id.textLC)
        textLocalC.visibility = View.VISIBLE
    }


    private fun irAreas(){
        val i = Intent(this,Areas::class.java)
        startActivity(i)
    }

}