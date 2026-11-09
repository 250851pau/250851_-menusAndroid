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

class Hoja4AccionActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja4_accion)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        txtResultado = findViewById(R.id.txtResultado)

        // ZONA A: aquí van las instrucciones del tutorial que van dentro de onCreate
        txtResultado.setOnLongClickListener {
            startSupportActionMode(actionModeCallback)
            true
        }
    }

    // ZONA B: aquí van las funciones del tutorial que van FUERA de onCreate
    private val actionModeCallback = object : androidx.appcompat.view.ActionMode.Callback {
        override fun onCreateActionMode(mode: androidx.appcompat.view.ActionMode?, menu: Menu?): Boolean {
            mode?.menuInflater?.inflate(R.menu.menu_hoja4, menu)
            return true
        }

        override fun onPrepareActionMode(mode: androidx.appcompat.view.ActionMode?, menu: Menu?): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: androidx.appcompat.view.ActionMode?, item: MenuItem?): Boolean {
            return when (item?.itemId) {
                R.id.opcion_editar -> {
                    txtResultado.text = getString(R.string.opcion_editar)
                    mode?.finish()
                    true
                }
                R.id.opcion_duplicar -> {
                    txtResultado.text = getString(R.string.opcion_duplicar)
                    mode?.finish()
                    true
                }
                R.id.opcion_archivar -> {
                    txtResultado.text = getString(R.string.opcion_archivar)
                    mode?.finish()
                    true
                }
                R.id.opcion_borrar -> {
                    txtResultado.text = getString(R.string.opcion_borrar)
                    mode?.finish()
                    true
                }
                else -> false
            }
        }

        override fun onDestroyActionMode(mode: androidx.appcompat.view.ActionMode?) {
            // No se requieren acciones adicionales al cerrar el modo de acción
        }
    }
}