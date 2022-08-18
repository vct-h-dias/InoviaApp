package com.example.byyou

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.byyou.databinding.ActivityLocalBinding

class Local : AppCompatActivity() {

    private lateinit var binding: ActivityLocalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocalBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val hitbox = findViewById<ImageView>(R.id.tr)
        val hitbox2 = findViewById<ImageView>(R.id.tr2)


        var bA = 0
        hitbox.setOnClickListener{

            VisibilidadeA()
            bA = 1


        }

        var bC = 0
        hitbox2.setOnClickListener{

            VisibilidadeC()
            bC = 1

        }


        val bt = findViewById<Button>(R.id.toMed)


        bt.setOnClickListener{
            val intent = Intent(this,Areas::class.java)

            if(bA==1&&bC==1){
                intent.putExtra("bolean", "11")
                startActivity(intent)
            }else if(bA==1){
                intent.putExtra("bolean", "10")
                startActivity(intent)
            }else{
                intent.putExtra("bolean", "1")
                startActivity(intent)
            }
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




//    private fun irAreas(){
//        val i = Intent(this,Areas::class.java)
//        startActivity(i)
//
//    }

}