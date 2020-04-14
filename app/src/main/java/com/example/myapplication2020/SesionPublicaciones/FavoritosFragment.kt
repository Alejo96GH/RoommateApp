package com.example.myapplication2020.SesionPublicaciones


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2020.R
import com.example.myapplication2020.SesionPrincipal.SesionRoom
import com.example.myapplication2020.model.Room.Arriendo
import com.example.myapplication2020.model.Room.ArriendoDAO
import kotlinx.android.synthetic.main.fragment_favoritos.view.*

/**
 * A simple [Fragment] subclass.
 */
class FavoritosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_favoritos, container, false)
        root.rv_arriendos.layoutManager = LinearLayoutManager(
            activity!!.applicationContext,
            RecyclerView.VERTICAL,
            false
        )

        root.rv_arriendos.setHasFixedSize(true)

        var arriendoDAO: ArriendoDAO = SesionRoom.database.ArriendoDAO()
        var allArriendos: List<Arriendo> = arriendoDAO.getArriendamientos()

        var arriendosRVAdapter =
            ArriendosRVAdapterFavoritos(
                activity!!.applicationContext,
                allArriendos as ArrayList<Arriendo>
            )
        root.rv_arriendos.adapter = arriendosRVAdapter
        return root
    }
}