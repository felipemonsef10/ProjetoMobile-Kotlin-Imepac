package com.example.projetoandroidaula

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class TelaPerfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_perfil)
        //No comando abaixo mando esconder o Toolbar
        supportActionBar?.hide();
    }
}