package com.example.myapplication2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_siguiente_agregar.*

class SiguienteAgregarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_siguiente_agregar)

        bt_visualizacion.setOnClickListener {
            val intent = Intent(this, UltimaAgregarActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, AgregarActivity::class.java)
        startActivity(intent)
        finish()
    }
}
