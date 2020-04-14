package com.example.myapplication2020.model.Firebase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_arriendos")
class ArriendoFirebase (
    @PrimaryKey @ColumnInfo(name = "id") val id: String = "",
    @ColumnInfo(name ="arrendamiento") val arrendamiento: String = "",
    @ColumnInfo(name ="descripcion") val descripcion: String = "",
    @ColumnInfo(name ="precio") val precio: Int = 0,
    @ColumnInfo(name ="direccion") val direccion: String = "",
    @ColumnInfo(name ="latitud") val latitud: String = "",
    @ColumnInfo(name ="longitud") val longitud: String = ""
)