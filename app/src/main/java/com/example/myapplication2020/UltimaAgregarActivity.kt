package com.example.myapplication2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ultima_agregar.*

class UltimaAgregarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ultima_agregar)

        bt_agregar.setOnClickListener{
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, SiguienteAgregarActivity::class.java)
        startActivity(intent)
        finish()
    }
}
