package com.example.myapplication2020.model.Room

import androidx.room.*
import com.example.myapplication2020.model.Room.Arriendo

@Dao
interface ArriendoDAO {

    @Insert
    fun insertArriendo(arriendo: Arriendo)

    @Query("SELECT * FROM tabla_arriendos")
    fun getArriendamientos() : List<Arriendo>

    @Query("SELECT * FROM tabla_arriendos WHERE arrendamiento LIKE :arriendo")
    fun searchArriendo(arriendo: String): Arriendo

    @Delete
    fun deleteArriendo(arriendo: Arriendo)

}

