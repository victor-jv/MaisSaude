package com.example.exercitarparaasadeconquistar

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.util.*

class Formulario : AppCompatActivity() {
    private lateinit var Weight : EditText
    private lateinit var Height : EditText
    private lateinit var tvInform : TextView
    private lateinit var tvBoasVindas : TextView

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        tvBoasVindas = findViewById(R.id.tvBoasVindas)
        Weight = findViewById(R.id.Weight)
        Height = findViewById(R.id.Height)
        tvInform = findViewById(R.id.tvInform)
        val Nome = intent.getStringExtra("UserName")
        tvBoasVindas.setText(getString(R.string.ola) +" $Nome , "+ getString(R.string.inform))

    }
    @SuppressLint("SetTextI18n")
    fun calcular(view: View){
        if(Weight.text.toString().isEmpty()||Height.text.toString().isEmpty())
            return

        tvInform.setText(
            "${
                String.format(Locale.US, "%.2f",
                    (Weight.text.toString().toDouble()/(Height.text.toString().toDouble()*2)))
            }")
    }
    fun calcularSemMostrar(view: View){
        val Nome = intent.getStringExtra("UserName")
        val Senha = intent.getStringExtra("UserPassword")
        if(Weight.text.toString().isEmpty()||Height.text.toString().isEmpty())
            return
        val altura = Height.text.toString()
        val peso = Weight.text.toString()
        val IMC = String.format(Locale.US, "%.2f",(Weight.text.toString().toDouble()/(Height.text.toString().toDouble()*2)))
        val Inform = Intent(this,MainActivity::class.java)
        Inform.putExtra("IMC",IMC)
        Inform.putExtra("UserName",Nome)
        Inform.putExtra("UserPassword",Senha)
        Inform.putExtra("Weight",peso)
        Inform.putExtra("Height",altura)
        startActivity(Inform)
    }
}