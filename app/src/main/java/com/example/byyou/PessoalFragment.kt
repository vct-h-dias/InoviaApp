package com.example.byyou

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.byyou.databinding.FragmentPessoalBinding


class PessoalFragment : Fragment(R.layout.fragment_pessoal) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPessoalBinding.inflate(layoutInflater)


        binding.cardView2.setOnClickListener(){
            abrirPaciente()
        }
        binding.cardView3.setOnClickListener(){
            abrirPaciente()
        }
        binding.cardView4.setOnClickListener(){
            abrirPaciente()
        }


        return binding.root
    }
    private fun abrirPaciente(){
        val i = Intent(this@PessoalFragment.requireContext(),Paciente::class.java)
        startActivity(i)
    }
}