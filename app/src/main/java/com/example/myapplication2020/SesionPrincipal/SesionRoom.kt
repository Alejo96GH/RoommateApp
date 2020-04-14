package com.example.myapplication2020.SesionPrincipal

import android.app.Application
import androidx.room.Room
import com.example.myapplication2020.model.Room.ArriendoDataBase

class SesionRoom : Application() {

    companion object {
        lateinit var database: ArriendoDataBase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            ArriendoDataBase::class.java,
            "arriendo_DB"
        )
            .allowMainThreadQueries()
            .build()
    }
}