package com.example.myapplication2020


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        return root

    }

}