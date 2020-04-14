package com.example.myapplication2020.model.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication2020.model.Room.Arriendo
import com.example.myapplication2020.model.Room.ArriendoDAO

@Database(entities = [Arriendo::class], version = 1)
abstract class ArriendoDataBase : RoomDatabase() {

    abstract fun ArriendoDAO(): ArriendoDAO

}