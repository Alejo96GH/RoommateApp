package com.example.myapplication2020.SesionPrincipal


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication2020.R
import com.example.myapplication2020.model.Firebase.ArriendoFirebase
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_mapa.*

/**
 * A simple [Fragment] subclass.
 */
class MapaFragment : Fragment(), OnMapReadyCallback {

    private lateinit  var mMap: GoogleMap
    private lateinit  var mapView: MapView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_mapa, container, false)

        mapView = root.findViewById(R.id.map)

        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        return root
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
    }

    private fun setMarkers(latitud: String?, longitud: String?, arrendamiento: String?, precio: Int?) {
        val marker = LatLng(latitud!!.toDouble(), longitud!!.toDouble())

        mMap.addMarker(
            MarkerOptions()
                .position(marker)
                .title(arrendamiento)
                .snippet(precio.toString())
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 14.2F))
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
        cargarArriendos()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    private fun cargarArriendos() {

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Arriendo")

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (snapshot in dataSnapshot.children) {
                    val arriendo = snapshot.getValue(ArriendoFirebase::class.java)
                    setMarkers(arriendo?.latitud, arriendo?.longitud, arriendo?.arrendamiento, arriendo?.precio)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Publicaciones", "Failed to read value.", error.toException())
            }
        })
    }

}