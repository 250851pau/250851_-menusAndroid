package com.utxicotepec.menusandroid

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Hoja3ContextualActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja3_contextual)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        txtResultado = findViewById(R.id.txtResultado)

        // ZONA A: aquí van las instrucciones del tutorial que van dentro de onCreate
        registerForContextMenu(txtResultado)
    }

    // ZONA B: aquí van las funciones del tutorial que van FUERA de onCreate
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_hoja3, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.opcion_copiar -> {
                txtResultado.text = getString(R.string.opcion_copiar)
                true
            }
            R.id.opcion_pegar -> {
                txtResultado.text = getString(R.string.opcion_pegar)
                true
            }
            R.id.opcion_cortar -> {
                txtResultado.text = getString(R.string.opcion_cortar)
                true
            }
            R.id.opcion_eliminar -> {
                txtResultado.text = getString(R.string.opcion_eliminar)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}