package com.example.myapplication2020.SesionAgregar
import android.content.Intent
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication2020.R
import com.example.myapplication2020.SesionPrincipal.PrincipalActivity
import com.example.myapplication2020.SesionPrincipal.SesionRoom
import com.example.myapplication2020.model.Firebase.ArriendoFirebase
import com.example.myapplication2020.model.Room.Arriendo
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_agregar_3.*
import java.sql.Types.NULL

class AgregarActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_3)

        var datosRecibidos = intent.extras
        val arriendo = datosRecibidos?.getString("Arriendo").toString()
        val ubicacion = datosRecibidos?.getString("Direccion").toString()
        val descripcion = datosRecibidos?.getString("Descripcion").toString()
        val precio = datosRecibidos?.getString("Precio").toString()

        tv_arrienda.text = arriendo
        tv_arriendoCard.text = arriendo
        tv_ubicacion.text = ubicacion
        tv_precio.text = precio + " $"
        tv_precioCard.text = precio
        tv_descripcion.text = descripcion


        val geocoder = Geocoder(applicationContext)

        lateinit var list: MutableList<Address>
        lateinit var latitud: String
        lateinit var longitud: String

        list = geocoder.getFromLocationName(ubicacion,1)

        if (list.size > 0){
            latitud = list.get(0).latitude.toString()
            longitud = list.get(0).longitude.toString()
        }

        bt_agregar.setOnClickListener{
            guardarEnFirebaseArriendo(arriendo, descripcion, precio, ubicacion, latitud, longitud)
            guardarEnFirebaseArriendoAgregado(arriendo, descripcion, precio, ubicacion, latitud, longitud)
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, AgregarActivity2::class.java)
        startActivity(intent)
        finish()
    }

    private fun guardarEnFirebaseArriendo(arrendamiento: String, descripcion: String, precio: String,
                                          ubicacion: String, latitud: String, longitud: String) {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Arriendo")

        var idArriendo = myRef.push().key

        val arrendaje = ArriendoFirebase(idArriendo!!, arrendamiento, descripcion, precio.toInt(),
                                        ubicacion, latitud, longitud)
        myRef.child(idArriendo).setValue(arrendaje)
    }

    private fun guardarEnFirebaseArriendoAgregado(arrendamiento: String, descripcion: String, precio: String,
                                                  ubicacion: String, latitud: String, longitud: String) {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("ArriendoAgregado")
        var idArriendo = myRef.push().key

        val arrendaje = ArriendoFirebase(idArriendo!!, arrendamiento, descripcion, precio.toInt(),
                                         ubicacion, latitud, longitud)
        myRef.child(idArriendo).setValue(arrendaje)
    }
}
