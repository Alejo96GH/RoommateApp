package com.example.myapplication2020.EtapaInicial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication2020.SesionPrincipal.PrincipalActivity
import com.example.myapplication2020.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sesion.*


class SesionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sesion)
        Log.d("Método", "OnCreate")

        bt_regi.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        bt_sesion.setOnClickListener {
            if (tiet_contraseñaM.text.toString().isEmpty()) {
                Toast.makeText(this, "Campo de contraseña vacio", Toast.LENGTH_SHORT).show()
            } else {
                val auth = FirebaseAuth.getInstance()
                auth.signInWithEmailAndPassword( tiet_correoM.text.toString(), tiet_contraseñaM.text.toString() )
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Log.d("SesionActivity", "signInWithEmail:success")
                            goToAplicacionActivity()
                        } else {
                            Log.w("SesionActivity", "signInWithEmail:failure", task.exception)
                            if (task.exception!!.message.equals(getString(R.string.error_msg_login_for_register))){
                                Toast.makeText( this, "Usted no está registrado", Toast.LENGTH_SHORT).show()
                            }
                            if (task.exception!!.message.equals(getString(R.string.error_msg_for_incorrect_password))){
                                Toast.makeText( this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
            }
        }
    }

    private fun goToAplicacionActivity() {
        val intent = Intent(this, PrincipalActivity::class.java)
        startActivity(intent)
        finish()
    }

/*
    public override fun onStart() {
        super.onStart()
        val auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            goToAplicacionActivity()
        }
    }
*/

}