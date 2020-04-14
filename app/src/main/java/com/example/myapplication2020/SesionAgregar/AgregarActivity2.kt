package com.example.myapplication2020.SesionAgregar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication2020.R
import kotlinx.android.synthetic.main.activity_agregar_2.*

class AgregarActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_2)

        var datosRecibidos = intent.extras
        val arriendo = datosRecibidos?.getString("Arriendo")
        val direccion = datosRecibidos?.getString("Direccion")

        bt_visualizacion.setOnClickListener {
            val descripcion = et_descripcion.text.toString()
            val precio = et_precio.text.toString()
            if(descripcion.isEmpty() || precio.isEmpty()){
                Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, AgregarActivity3::class.java)
                intent.putExtra("Arriendo", arriendo)
                intent.putExtra("Direccion", direccion)
                intent.putExtra("Descripcion", descripcion)
                intent.putExtra("Precio", precio)
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, AgregarActivity1::class.java)
        startActivity(intent)
        finish()
    }
}
