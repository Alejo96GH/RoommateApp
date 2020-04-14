package com.example.myapplication2020.SesionPublicaciones

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2020.R
import com.example.myapplication2020.SesionDescripcion.DescripcionPublicacionesActivity
import com.example.myapplication2020.model.Firebase.ArriendoFirebase
import kotlinx.android.synthetic.main.item_arriendo.view.*

class ArriendosRVAdapterPublicaciones(
    private var context: Context,
    private var arriendosList: ArrayList<ArriendoFirebase>
) : RecyclerView.Adapter<ArriendosRVAdapterPublicaciones.ArriendosViewHolder>() {

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
        val arriendo: ArriendoFirebase = arriendosList[position]
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

        fun bindArriendo(arriendo: ArriendoFirebase) {
            itemView.tv_arriendo.text = arriendo.arrendamiento
            itemView.tv_precio.text = arriendo.precio.toString()
            itemView.setOnClickListener {

                var intent = Intent(context, DescripcionPublicacionesActivity::class.java)
                intent.putExtra("id", arriendo.id).addFlags(FLAG_ACTIVITY_NEW_TASK)
                intent.putExtra("arriendo", arriendo.arrendamiento).addFlags(FLAG_ACTIVITY_NEW_TASK)
                intent.putExtra("descripcion", arriendo.descripcion).addFlags(FLAG_ACTIVITY_NEW_TASK)
                intent.putExtra("precio", arriendo.precio).addFlags(FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)

            }
        }
    }
}



