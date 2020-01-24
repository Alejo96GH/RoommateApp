package com.example.myapplication2020

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

var correo = "."
var contraseña = "."

var nombreM = ""
var correoM = ""
var contraseñaM = ""

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Método", "OnCreate")

        bt_sesion.setOnClickListener {
            correoM = et_correoM.text.toString()
            contraseñaM = et_contraseñaM.text.toString()

            if (correoM == correo) {
                if (contraseñaM == contraseña) {
                    tv_ensayo.text = "Si"

                    var intent = Intent(this, AplicacionActivity::class.java)
                    intent.putExtra( "nombre", nombreM)
                    intent.putExtra( "correo", correoM)
                    intent.putExtra( "password",  contraseñaM)
                    startActivity(intent)

                } else {
                    Toast.makeText( this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                }
            }

            else{
                Toast.makeText( this, "Usted no está registrado", Toast.LENGTH_SHORT).show()
                tv_ensayo.text = "No"
            }
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("Método", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Método", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Método", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Método", "OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Método", "OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Método", "OnDestroy")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.punticos1) {
            var intent = Intent(this, ReceptorActivity::class.java)
            // Usarlos cuando se desee enviar informacion de actividad a actividad
            //       intent.putExtra( "Nombre", "Edwin" )
            //       intent.putExtra( "Calificacion", 5)
            startActivityForResult(intent, 1234)
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 1234 && resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "Bienvenido " + data?.extras?.getString("nombre"), Toast.LENGTH_SHORT).show()
            super.onActivityResult(requestCode, resultCode, data)

            nombreM = data?.extras?.getString("nombre").toString()
            correo = data?.extras?.getString("correo").toString()
            contraseña = data?.extras?.getString("password").toString()

        }
        else{
            if(requestCode == 1234){
                Toast.makeText( this, "Registro fallido", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}
