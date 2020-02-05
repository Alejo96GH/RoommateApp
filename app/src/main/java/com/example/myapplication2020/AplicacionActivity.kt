package com.example.myapplication2020

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_aplicacion.*
import kotlinx.android.synthetic.main.activity_receptor.*

class AplicacionActivity : AppCompatActivity() {

    var nombreA = ""
    var correoA = ""
    var passwordA = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aplicacion)
        var datosRecibidos = intent.extras
        nombreA = datosRecibidos?.getString("nombre").toString()
        correoA = datosRecibidos?.getString("correo").toString()
        passwordA = datosRecibidos?.getString("password").toString()
        tv_bienvenido.text = "Bienvenido " + nombreA +""

        bt_agregar.setOnClickListener {
            Toast.makeText( this, "Seleccionada la opción de agregar", Toast.LENGTH_SHORT).show()
        }

        bt_buscar.setOnClickListener {
            Toast.makeText( this, "Seleccionada la opción de buscar", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.punticos2) {

            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra( "nombre", nombreA)
            intent.putExtra( "correo", correoA)
            intent.putExtra( "password",  passwordA)
            startActivity(intent)
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }




    //override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    //    super.onActivityResult(requestCode, resultCode, data)
    //    correoA = data?.extras?.getString("correo").toString()
    //    Toast.makeText( this, "Problemas", Toast.LENGTH_SHORT).show()
    //    tv_correoA.text = correoA
    //  }
       // else{
       //         Toast.makeText( this, "Problemas", Toast.LENGTH_SHORT).show()
       // }

}
