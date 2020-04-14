package com.example.myapplication2020.EtapaInicial

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication2020.R
import com.example.myapplication2020.model.Firebase.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase

import kotlinx.android.synthetic.main.activity_register.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        bt_registrar.setOnClickListener{

            var intent = Intent()

            if (tiet_contraseña.text.toString() == tiet_contraseña1.text.toString()) {

                if (tiet_correo.text.toString().isEmpty() || tiet_contraseña.text.toString().isEmpty() || tiet_contraseña1.text.toString().isEmpty()) {
                    Toast.makeText(this, "Debe diligenciar todos los campos", Toast.LENGTH_SHORT).show()
                }
                else if (tiet_contraseña.text.toString().length < 6){
                    Toast.makeText(this, "Contraseña muy corta", Toast.LENGTH_SHORT).show()
                }
                else {
                    val auth = FirebaseAuth.getInstance()
                    if (isEmailValid(tiet_correo.text.toString())){
                        auth.createUserWithEmailAndPassword( tiet_correo.text.toString(), tiet_contraseña.text.toString() )
                            .addOnCompleteListener(this) { task ->
                                if (task.isSuccessful) {
                                    Log.d("RegisterActivity", "signInWithEmail:success")
                                    val user = auth.currentUser
                                    createUserDatabase(user)
                                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT)
                                    goToSesionActivity()
                                } else {
                                    Log.w("RegisterActivity", "signInWithEmail:failure", task.exception)
                                    if (task.exception!!.message.equals(getString(R.string.error_msg_register))) {
                                        Toast.makeText(this, "Usted ya está registrado", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }
                        }
                }
            }

            else{
                Toast.makeText( this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun createUserDatabase(user: FirebaseUser?) {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("ususarios")
        val usuario = Usuario(
            user!!.uid,
            user!!.email.toString()
        )
        myRef.child(user!!.uid).setValue(usuario)
    }

    private fun goToSesionActivity(){
        val intent = Intent(this, SesionActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun isEmailValid(email: String?): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
    }

}
