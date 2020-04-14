package com.example.myapplication2020.SesionAgregar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication2020.R
import com.example.myapplication2020.SesionPrincipal.PrincipalActivity
import kotlinx.android.synthetic.main.activity_agregar_1.*

class AgregarActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_1)
        var arriendo: String = "Casa en "

        rb_apartamento.setOnClickListener{
            arriendo = "Apartamento en "
        }
        rb_casa.setOnClickListener{
            arriendo = "Casa en "
        }
        rb_habitacion.setOnClickListener{
            arriendo = "Habitación en "
        }

        bt_siguiente.setOnClickListener{

            val barrio = et_barrio.text.toString()
            val direccion = et_direccion.text.toString()

            if(barrio.isEmpty() or direccion.isEmpty()){
                Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT).show()
            }
            else {
                arriendo += barrio
                val intent = Intent(this, AgregarActivity2::class.java)
                intent.putExtra("Arriendo", arriendo)
                intent.putExtra("Direccion", direccion)
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
            val intent = Intent(this, PrincipalActivity::class.java)
        startActivity(intent)
        finish()
    }

}
