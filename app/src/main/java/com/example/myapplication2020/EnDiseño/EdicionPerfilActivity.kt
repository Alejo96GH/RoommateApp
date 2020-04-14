package com.example.myapplication2020.EnDiseño

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication2020.R
import com.example.myapplication2020.model.Firebase.DatosFirebase
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_edicion_perfil.*

class EdicionPerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edicion_perfil)

        bt_enviar.setOnClickListener{
            val nombre = et_nombre.text.toString()
            val cedula = et_cedula.text.toString()
            val correo = et_correo.text.toString()
            var telefono = et_telefono.text.toString()
            val direccion = et_direccion.text.toString()

            if (et_nombre.text.toString().isEmpty() ||
                et_cedula.text.toString().isEmpty() ||
                et_correo.text.toString().isEmpty() ||
                et_telefono.text.toString().isEmpty() ||
                et_direccion.text.toString().isEmpty() ){
                Toast.makeText(this, "Ingrese todos los datos", Toast.LENGTH_SHORT).show()
            }
            else {
                guardarEnFirebase(nombre, cedula, correo, telefono, direccion)
                var intent = Intent()
                intent.putExtra("nombre", nombre)
                intent.putExtra("cedula", cedula)
                intent.putExtra("correo", correo)
                intent.putExtra("telefono", telefono)
                intent.putExtra("direccion", direccion)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }

    }

    private fun guardarEnFirebase(nombre: String, cedula: String, correo: String, telefono: String, direccion: String) {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("DatosPersonales")

        var idDatos = myRef.push().key

        val datos = DatosFirebase(idDatos!!, nombre, cedula, correo, telefono, direccion)
        myRef.child(idDatos).setValue(datos)
    }
}
