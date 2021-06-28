package com.example.nimmer_quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.nimmer_quizz.http.HttpHelper
import com.example.nimmer_quizz.model.Cadastro
import com.google.gson.Gson
import org.jetbrains.anko.doAsync

class register_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide();
        setContentView(R.layout.register_activity)

        val buttonRegistrar = findViewById<Button>(R.id.button_register)
        val editTextNome = findViewById<EditText>(R.id.name_input)
        val editTextEmail = findViewById<EditText>(R.id.email_input)
        val editTextData = findViewById<EditText>(R.id.data_input)
        val editTextSenha = findViewById<EditText>(R.id.senha_input)

        buttonRegistrar.setOnClickListener{
            // criar um objeto cadastro

            val cadastro = Cadastro()

            cadastro.nome = editTextNome.text.toString()
            cadastro.data = editTextData.text.toString()
            cadastro.email = editTextEmail.text.toString()
            cadastro.senha = editTextSenha.text.toString()

            // converter o cadastro pra json

            val gson = Gson()
            val cadastoJson = gson.toJson(cadastro)

            doAsync {
                val http = HttpHelper()
                http.post(cadastoJson)
            }
        }
    }
}