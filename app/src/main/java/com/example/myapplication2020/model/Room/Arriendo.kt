package com.example.myapplication2020.model.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_arriendos")
class Arriendo (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name ="arrendamiento") val arrendamiento: String,
    @ColumnInfo(name ="descripcion") val descripcion: String,
    @ColumnInfo(name ="precio") val precio: Int
)