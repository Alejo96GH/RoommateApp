package com.example.myapplication2020.SesionDescripcion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication2020.R
import com.example.myapplication2020.SesionPrincipal.SesionRoom
import com.example.myapplication2020.model.Room.Arriendo
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_descripcion_publicaciones.*
import java.sql.Types.NULL

class DescripcionPublicacionesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descripcion_publicaciones)
        var datosRecibidos = intent.extras
        val id = datosRecibidos?.getString("id").toString()
        val arriendo = datosRecibidos?.getString("arriendo").toString()
        val descripcion = datosRecibidos?.getString("descripcion").toString()
        val precio = intent?.getSerializableExtra("precio").toString()

        tv_arrienda.text = arriendo
        tv_descripcion.text = descripcion
        tv_precio.text = precio

        bt_eliminar.setOnClickListener{
            val database = FirebaseDatabase.getInstance()
            eliminarPublicacionArriendoAgregado(database, id)
            eliminarPublicacionArriendo(database, id)
            Toast.makeText(this, "Publicación eliminada", Toast.LENGTH_SHORT).show()
            finish()
        }

    }

    private fun eliminarPublicacionArriendoAgregado(database: FirebaseDatabase, id: String) {
        val myRef = database.getReference("ArriendoAgregado")
        myRef.child(id).removeValue()
    }

    private fun eliminarPublicacionArriendo(database: FirebaseDatabase, id: String) {
        val myRef = database.getReference("Arriendo")
        myRef.child(id).removeValue()
    }
}