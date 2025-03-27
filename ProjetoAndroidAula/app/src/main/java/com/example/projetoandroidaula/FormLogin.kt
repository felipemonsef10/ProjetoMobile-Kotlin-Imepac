package com.example.projetoandroidaula

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class FormLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)
        //No comando abaixo mando esconder o Toolbar
        supportActionBar?.hide();

        val linkFormCadastro = findViewById<TextView>(R.id.text_tela_cadastro)
        linkFormCadastro.setOnClickListener {
            val telaCadastro = Intent(this, FormCadastro::class.java)
            startActivity(telaCadastro)
        }
    }
}