package com.example.myapplication2020.SesionPublicaciones

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2020.R
import com.example.myapplication2020.SesionDescripcion.DescripcionFavoritosActivity
import com.example.myapplication2020.model.Room.Arriendo
import kotlinx.android.synthetic.main.item_arriendo.view.*

class ArriendosRVAdapterFavoritos(
    var context: Context,
    var arriendosList: ArrayList<Arriendo>
) : RecyclerView.Adapter<ArriendosRVAdapterFavoritos.ArriendosViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArriendosViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.item_arriendo, parent, false)
        return ArriendosViewHolder(
            itemView,
            context
        )
    }

    override fun getItemCount(): Int = arriendosList.size

    override fun onBindViewHolder(
        holder: ArriendosViewHolder,
        position: Int
    ) {
        val arriendo: Arriendo = arriendosList[position]
        holder.bindArriendo(arriendo)
    }

    class ArriendosViewHolder(
        itemView: View,
        context: Context
    ) : RecyclerView.ViewHolder(itemView) {

        private var context: Context

        init {
            this.context = context
        }

        fun bindArriendo(arriendo: Arriendo) {
            itemView.tv_arriendo.text = arriendo.arrendamiento
            itemView.tv_precio.text = arriendo.precio.toString()
            itemView.setOnClickListener {

                var intent = Intent(context, DescripcionFavoritosActivity::class.java)
                intent.putExtra("id", arriendo.id).addFlags(FLAG_ACTIVITY_NEW_TASK)
                intent.putExtra("arriendo", arriendo.arrendamiento).addFlags(FLAG_ACTIVITY_NEW_TASK)
                intent.putExtra("descripcion", arriendo.descripcion).addFlags(FLAG_ACTIVITY_NEW_TASK)
                intent.putExtra("precio", arriendo.precio).addFlags(FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)

            }
           }
    }
}






