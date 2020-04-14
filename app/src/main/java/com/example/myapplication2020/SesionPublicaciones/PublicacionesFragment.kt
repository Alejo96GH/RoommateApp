package com.example.myapplication2020.SesionPublicaciones

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2020.R
import com.example.myapplication2020.SesionPrincipal.ArriendosRVAdapter
import com.example.myapplication2020.model.Firebase.ArriendoFirebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_publicaciones.view.*

class PublicacionesFragment : Fragment() {

    val allArriendos: MutableList<ArriendoFirebase> = mutableListOf()
    lateinit var arriendosRVAdapterPublicaciones: ArriendosRVAdapterPublicaciones

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_publicaciones, container, false)

        arriendosRVAdapterPublicaciones =
            ArriendosRVAdapterPublicaciones(
                activity!!.applicationContext,
                allArriendos as ArrayList<ArriendoFirebase>
            )

        root.rv_arriendos.layoutManager = LinearLayoutManager(
            activity!!.applicationContext,
            RecyclerView.VERTICAL,
            false
        )
        root.rv_arriendos.setHasFixedSize(true)

        root.rv_arriendos.adapter = arriendosRVAdapterPublicaciones

        return root
    }

    override fun onResume() {
        super.onResume()
        cargarArriendos()
    }

    private fun cargarArriendos() {

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("ArriendoAgregado")

        allArriendos.clear()

        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (snapshot in dataSnapshot.children) {
                    val arriendo = snapshot.getValue(ArriendoFirebase::class.java)
                    allArriendos.add(arriendo!!)
                }
                arriendosRVAdapterPublicaciones.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Publicaciones", "Failed to read value.", error.toException())
            }
        })
    }

}
