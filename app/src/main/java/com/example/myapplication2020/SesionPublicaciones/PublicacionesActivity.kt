package com.example.myapplication2020.SesionPublicaciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication2020.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class PublicacionesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publicaciones)


        val navView: BottomNavigationView = findViewById(R.id.navp_view)

        val navController = findNavController(R.id.navp_host_fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.mo_publicaciones,
                R.id.mo_favoritos
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }
}
