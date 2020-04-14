package com.example.myapplication2020.model.Firebase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_datos")
class DatosFirebase(
    @PrimaryKey @ColumnInfo(name = "id") val id: String = "",
    @ColumnInfo(name ="nombre") val nombre: String = "",
    @ColumnInfo(name ="cedula") val cedula: String = "",
    @ColumnInfo(name ="correo") val correo: String = "",
    @ColumnInfo(name ="telefono") val telefono: String = "",
    @ColumnInfo(name ="direccion") val direccion: String = ""
)