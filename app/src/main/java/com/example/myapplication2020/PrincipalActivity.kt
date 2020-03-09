package com.example.myapplication2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class PrincipalActivity : AppCompatActivity() {

    var nombreA = ""
    var correoA = ""
    var passwordA = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        var datosRecibidos = intent.extras
        nombreA = datosRecibidos?.getString("nombre").toString()
        correoA = datosRecibidos?.getString("correo").toString()
        passwordA = datosRecibidos?.getString("password").toString()



        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.mo_lista, R.id.mo_mapa, R.id.mo_perfil
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_cerrar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.punticos) {
            var intent = Intent(this, SesionActivity::class.java)
            intent.putExtra( "nombre", nombreA)
            intent.putExtra( "correo", correoA)
            intent.putExtra( "password",  passwordA)
            startActivity(intent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}

