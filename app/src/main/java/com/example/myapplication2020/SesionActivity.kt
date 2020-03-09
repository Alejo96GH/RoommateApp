package com.example.myapplication2020

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sesion.*


class SesionActivity : AppCompatActivity() {

    var correo = "."
    var contraseña = "."
    var nombre = ""

    var correom = ""
    var contraseñam = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sesion)
        Log.d("Método", "OnCreate")

        bt_regi.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivityForResult(intent, 1234)
        }

        bt_sesion.setOnClickListener {

            val auth = FirebaseAuth.getInstance()

            auth.signInWithEmailAndPassword(tiet_correoM.text.toString(), tiet_contraseñaM.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d("SesionActivity", "signInWithEmail:success")
                        goToMainActivity()
                    } else {
                        Log.w("SesionActivity", "signInWithEmail:failure", task.exception)
                        if (task.exception!!.message.equals(getString(R.string.error_msg_login))){
                            Toast.makeText( this, "Usted no está registrado", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            correom = tiet_correoM.text.toString()
            contraseñam = tiet_contraseñaM.text.toString()



            if (correom == correo) {
                if (contraseñam == contraseña) {

                    val intent = Intent(this, PrincipalActivity::class.java)
                    intent.putExtra( "nombre", nombre)
                    intent.putExtra( "correo", correom)
                    intent.putExtra( "password",  contraseñam)
                    startActivity(intent)
                    finish()

                } else {
                    Toast.makeText( this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                }
            }

            else{
            }
        }

    }


    private fun goToMainActivity() {
        val intent = Intent(this, PrincipalActivity::class.java)
        startActivity(intent)
        finish()
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


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 1234 && resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, data?.extras?.getString("nombre") + ", usted ha sido registrado." , Toast.LENGTH_SHORT).show()
            super.onActivityResult(requestCode, resultCode, data)

            nombre = data?.extras?.getString("nombre").toString()
            correo = data?.extras?.getString("correo").toString()
            contraseña = data?.extras?.getString("password").toString()

        }

        else{
            if(requestCode == 1234){
                Toast.makeText( this, "Registro fallido", Toast.LENGTH_SHORT).show()
            }
        }

        if(requestCode == 1996) {
            Toast.makeText( this, "Sesión cerrada", Toast.LENGTH_SHORT).show()
        }
    }

}