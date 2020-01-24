package com.example.myapplication2020

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_receptor.*

class ReceptorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receptor)


        bt_registrar.setOnClickListener{
            var nombreR :String = et_nombre.text.toString()
            var correoR :String = et_correo.text.toString()
            var passwordR :String = et_contraseña.text.toString()
            var intent = Intent()

            if(correoR.isEmpty() || passwordR.isEmpty()){
                setResult(Activity.RESULT_CANCELED,intent)
            }
            else{
                intent.putExtra( "nombre",  nombreR)
                intent.putExtra( "correo", correoR )
                intent.putExtra( "password",  passwordR)

                setResult(Activity.RESULT_OK,intent)
            }
            finish()
        }


    }

}
