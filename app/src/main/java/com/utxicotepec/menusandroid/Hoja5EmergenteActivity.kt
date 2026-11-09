package com.utxicotepec.menusandroid

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Hoja5EmergenteActivity : AppCompatActivity() {
    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja5_emergente)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }
        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))
        txtResultado = findViewById(R.id.txtResultado)

        // ZONA A: Todo el código del menú emergente va aquí dentro
        val btnMostrar = findViewById<Button>(R.id.btnMostrarMenu)
        btnMostrar.setOnClickListener { view ->
            val popup = PopupMenu(this, view)
            popup.menuInflater.inflate(R.menu.menu_hoja5, popup.menu)
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.opcion_ver_perfil -> {
                        txtResultado.text = getString(R.string.opcion_ver_perfil)
                        true
                    }
                    R.id.opcion_enviar_mensaje -> {
                        txtResultado.text = getString(R.string.opcion_enviar_mensaje)
                        true
                    }
                    R.id.opcion_bloquear -> {
                        txtResultado.text = getString(R.string.opcion_bloquear)
                        true
                    }
                    R.id.opcion_reportar -> {
                        txtResultado.text = getString(R.string.opcion_reportar)
                        true
                    }
                    else -> false
                }
            }
            popup.show()
        }
    }

    // ZONA B: Se queda vacía en esta hoja
}