package com.example.myapplication2020.SesionPrincipal


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication2020.EnDiseño.EdicionPerfilActivity
import com.example.myapplication2020.R
import com.example.myapplication2020.SesionPublicaciones.PublicacionesActivity
import kotlinx.android.synthetic.main.fragment_perfil.*
import kotlinx.android.synthetic.main.fragment_perfil.view.*

/**
 * A simple [Fragment] subclass.
 */
class PefilFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_perfil, container, false)

        root.bt_publicaciones.setOnClickListener{
            val intent = Intent(context, PublicacionesActivity::class.java)
            startActivity(intent)
        }

        root.bt_editar.setOnClickListener{
            val intent = Intent(context, EdicionPerfilActivity::class.java)
            startActivityForResult(intent, 1234)
        }

        return root

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1234 && resultCode == Activity.RESULT_OK){
            var datosRecibidos = data?.extras
            val nombre = datosRecibidos?.getString("nombre")
            val cedula = datosRecibidos?.getString("cedula")
            val correo = datosRecibidos?.getString("correo")
            val telefono = datosRecibidos?.getString("telefono")
            val direccion = datosRecibidos?.getString("direccion")

            tv_nombre.text = nombre
            tv_cedula.text = cedula
            tv_correo.text = correo
            tv_telefono.text = telefono
            tv_direccion.text = direccion
        }
    }

}