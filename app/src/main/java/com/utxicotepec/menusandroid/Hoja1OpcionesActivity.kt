package com.utxicotepec.menusandroid

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Hoja1OpcionesActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja1_opciones)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        txtResultado = findViewById(R.id.txtResultado)

        // ZONA A: aquí van las instrucciones del tutorial que van dentro de onCreate
    }

    // ZONA B: aquí van las funciones del tutorial que van FUERA de onCreate
    // ZONA B: funciones del tutorial que van FUERA de onCreate

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_hoja1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.opcion_buscar -> {
                txtResultado.text = getString(R.string.opcion_buscar)
                true
            }
            R.id.opcion_configuracion -> {
                txtResultado.text = getString(R.string.opcion_configuracion)
                true
            }
            R.id.opcion_acerca_de -> {
                txtResultado.text = getString(R.string.opcion_acerca_de)
                true
            }
            R.id.opcion_compartir -> {
                txtResultado.text = getString(R.string.opcion_compartir)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}