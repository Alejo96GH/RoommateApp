package com.example.myapplication2020.SesionDescripcion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication2020.R
import com.example.myapplication2020.SesionPrincipal.SesionRoom
import com.example.myapplication2020.model.Room.Arriendo
import com.example.myapplication2020.model.Room.ArriendoDAO
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_descripcion_favoritos.*
import java.sql.Types.NULL

class DescripcionFavoritosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descripcion_favoritos)
        var datosRecibidos = intent.extras

        val id = intent?.getSerializableExtra("id").toString()
        val arriendo = datosRecibidos?.getString("arriendo").toString()
        val descripcion = datosRecibidos?.getString("descripcion").toString()
        val precio = intent?.getSerializableExtra("precio").toString()

        tv_arrienda.text = arriendo
        tv_descripcion.text = descripcion
        tv_precio.text = precio

        bt_eliminar.setOnClickListener{

            val arriendoDAO : ArriendoDAO = SesionRoom.database.ArriendoDAO()
            val arrendaje = arriendoDAO.searchArriendo(arriendo)

            arriendoDAO.deleteArriendo(arrendaje)
            Toast.makeText(this, "Eliminada de favoritos", Toast.LENGTH_SHORT).show()
            finish()
        }

        bt_chat.setOnClickListener{
            var intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }

    }
}