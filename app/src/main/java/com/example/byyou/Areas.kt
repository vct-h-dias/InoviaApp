package com.example.byyou

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.byyou.databinding.ActivityAreasBinding


class Areas : AppCompatActivity() {

    private lateinit var binding: ActivityAreasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAreasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniciarA()

        val btMed: Button = findViewById(R.id.toMedFoto1)
        btMed.setOnClickListener{
            irMedicoes()
        }

    }

    private fun iniciarA(){

        val bol = intent.getStringExtra("bolean")

        if(bol=="11"){
            binding.textL.visibility = View.VISIBLE
            binding.checkBox1.visibility = View.VISIBLE
            binding.checkBox2.visibility = View.VISIBLE
            binding.checkBox3.visibility = View.VISIBLE
            binding.checkBox4.visibility = View.VISIBLE

            binding.textC.visibility = View.VISIBLE
            binding.checkBoxDois.visibility = View.VISIBLE
            binding.checkBox2Dois.visibility = View.VISIBLE
            binding.checkBox3Dois.visibility = View.VISIBLE
            binding.checkBox4Dois.visibility = View.VISIBLE
        }
        if(bol=="10"){
            binding.textL.visibility = View.VISIBLE
            binding.checkBox1.visibility = View.VISIBLE
            binding.checkBox2.visibility = View.VISIBLE
            binding.checkBox3.visibility = View.VISIBLE
            binding.checkBox4.visibility = View.VISIBLE

        }
        if(bol=="1"){
            binding.textC.visibility = View.VISIBLE
            binding.checkBoxDois.visibility = View.VISIBLE
            binding.checkBox2Dois.visibility = View.VISIBLE
            binding.checkBox3Dois.visibility = View.VISIBLE
            binding.checkBox4Dois.visibility = View.VISIBLE
        }


    }

    private fun irMedicoes(){
        val intentMed = Intent(this,Med1::class.java)
        startActivity(intentMed)
    }

}