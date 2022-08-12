

package com.example.byyou

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Agenda : AppCompatActivity(), View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener{

//    private lateinit var buttonPessoal: Button
//    private lateinit var buttonClinica: Button

    private lateinit var pessoalFragment: PessoalFragment
    private lateinit var clinicaFragment: ClinicaFragment

    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_agenda)

//        buttonPessoal = findViewById(R.id.pessoal)
//        buttonPessoal.setOnClickListener(this)
//
//        buttonClinica = findViewById(R.id.clinica)
//        buttonClinica.setOnClickListener(this)

        pessoalFragment = PessoalFragment()
        clinicaFragment = ClinicaFragment()

        bottomNavigationView = findViewById(R.id.bottom_navagation)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        setFragment(pessoalFragment)

        val card: CardView = findViewById(R.id.cardViewP)
        card.setOnClickListener {
            abrirPaciente()
        }


    }

    private fun abrirPaciente(){
        val intention = Intent(this,Paciente::class.java)
        startActivity(intention)

    }

    private fun setFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_fragments, fragment)
        fragmentTransaction.commit()
    }

    override fun onClick(v: View) {
//        when(v.id){
//            R.id.pessoal -> {
//                setFragment(pessoalFragment)
//            }
//            R.id.clinica -> {
//                setFragment(clinicaFragment)
//            }
//        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_pessoal -> {
                setFragment(pessoalFragment)
            }
            R.id.menu_clinica -> {
                setFragment(clinicaFragment)
            }
        }

        return true
    }




}