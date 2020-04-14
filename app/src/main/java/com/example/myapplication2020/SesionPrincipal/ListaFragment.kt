package com.example.myapplication2020.SesionPrincipal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2020.R
import com.example.myapplication2020.SesionAgregar.AgregarActivity1
import com.example.myapplication2020.model.Firebase.ArriendoFirebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.fragment_publicaciones.view.rv_arriendos

class ListaFragment : Fragment() {

    val allArriendos: MutableList<ArriendoFirebase> = mutableListOf()
    lateinit var arriendosRVAdapter: ArriendosRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_list, container, false)

        root.bt_agregar.setOnClickListener{
            val intent = Intent(context, AgregarActivity1::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

        arriendosRVAdapter =
            ArriendosRVAdapter(
                activity!!.applicationContext,
                allArriendos as ArrayList<ArriendoFirebase>
            )

        root.rv_arriendos.layoutManager = LinearLayoutManager(
            activity!!.applicationContext,
            RecyclerView.VERTICAL,
            false
        )
        root.rv_arriendos.setHasFixedSize(true)

        root.rv_arriendos.adapter = arriendosRVAdapter

        return root
    }

    override fun onResume() {
        super.onResume()
        cargarArriendos()
    }

    private fun cargarArriendos() {

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Arriendo")

        allArriendos.clear()

        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (snapshot in dataSnapshot.children) {
                    val arriendo = snapshot.getValue(ArriendoFirebase::class.java)
                    allArriendos.add(arriendo!!)
                }
                arriendosRVAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Publicaciones", "Failed to read value.", error.toException())
            }
        })
    }

}