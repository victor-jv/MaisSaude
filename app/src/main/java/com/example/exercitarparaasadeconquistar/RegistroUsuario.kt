package com.example.exercitarparaasadeconquistar

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class RegistroUsuario : AppCompatActivity() {
    private lateinit var edN: EditText
    private lateinit var edS: EditText
    private lateinit var ConfirmaS: EditText
    private lateinit var Erro: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_usuario)

        Erro = findViewById(R.id.Erro)
        edN = findViewById(R.id.edN)
        edS = findViewById(R.id.edS)
        ConfirmaS = findViewById(R.id.ConfirmaS)
    }

    fun signup(view:View){
        if(edN.text.toString().isEmpty()||edS.text.toString().isEmpty()||ConfirmaS.text.toString().isEmpty()){
            Erro.setText(getString(R.string.mensagem_erro))
            Erro.visibility = View.VISIBLE
        }else if (ConfirmaS.text.toString() == edS.text.toString()){
            val UserName = edN.text.toString()
            val UserPassword = edS.text.toString()
            val Form = Intent(this,Formulario::class.java)
            Form.putExtra("UserName",UserName)
            Form.putExtra("UserPassword",UserPassword)
            startActivity(Form)
        }else{
            edS.setText("")
            ConfirmaS.setText("")
            Erro.setText(getString(R.string.unconfirmed_password))
            Erro.visibility = View.VISIBLE
        }


    }

}