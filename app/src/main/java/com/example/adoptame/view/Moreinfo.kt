package com.example.adoptame.view

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import com.example.adoptame.R
import com.example.adoptame.viewmodel.DataViewModel
import de.hdodenhof.circleimageview.CircleImageView

class Moreinfo : AppCompatActivity() {

    lateinit var viewModel: DataViewModel
    lateinit var img: CircleImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moreinfo)

        viewModel = ViewModelProviders.of(this).get(DataViewModel::class.java)

        val nombre = intent.getStringExtra("nombre")
        val descripcion = intent.getStringExtra("Descripcion")
        val ubicacion = intent.getStringExtra("Ubicacion")
        val cantEstrells = intent.getFloatExtra("cantEst",0.0F)
        val imagenurl = intent.getStringExtra("imagenurl")

        val txtNombre = findViewById<TextView>(R.id.txtNombre)
        val txtDesc = findViewById<TextView>(R.id.txtDescripcion)
        val rating = findViewById<RatingBar>(R.id.RatingMore)
        val txtPrecio = findViewById<TextView>(R.id.txtPrecio)
        img = findViewById<CircleImageView>(R.id.imgMoreInfo)

        txtNombre.setText(nombre)
        txtDesc.setText(descripcion)
        txtPrecio.setText(ubicacion.toString())
        rating.rating = cantEstrells
        img.setImageURI(Uri.parse(imagenurl))
    }

}