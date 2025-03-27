package com.example.projetoandroidaula

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Snackbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class FormCadastro : AppCompatActivity() {
    //Criando as variáveis para receber os id
    private lateinit var edit_nome: EditText
    private lateinit var edit_email: EditText
    private lateinit var edit_senha: EditText
    private lateinit var btnCadastrar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro)
        supportActionBar?.hide();

        //O que tiver no elemento será enviado para a variável
        edit_nome = findViewById(R.id.edit_nome)
        edit_email = findViewById(R.id.edit_email)
        edit_senha = findViewById(R.id.edit_senha)
        btnCadastrar = findViewById(R.id.btn_cadastro)

        btnCadastrar.setOnClickListener {
            val nome = edit_nome.text.toString().trim()
            val email = edit_email.text.toString().trim()
            val senha = edit_senha.text.toString().trim()

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                val mensagemErro = "Campos não preenchidos, tente novamente."
                val snackbar = Snackbar.make(it, mensagemErro, Snackbar.LENGTH_LONG)
                snackbar.show();
            } else {
                cadastrarUsuario(it)
            }
        }
    }


    @SuppressLint("ShowToast")
    fun cadastrarUsuario(it: View){
        val email = edit_email.text.toString().trim()
        val senha = edit_senha.text.toString().trim()
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener { task-> //task é o objeto do resultado vindo do firebase
                if (task.isSuccessful){
                    val mensagemOk = "Cadastro realizado com sucesso"
                    val snackbar = Snackbar.make(it, mensagemOk, Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    val mensagemErro = "Erro ao cadastrar usuário"
                    val snackbar = Snackbar.make(it, mensagemErro, Snackbar.LENGTH_LONG);
                    snackbar.show()
                }
        }
    }
}





//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
