package com.example.adoptame.presentacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast

import com.example.adoptame.R
import org.imaginativeworld.whynotimagecarousel.ImageCarousel

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener

class Inicio : AppCompatActivity() {
    val list = mutableListOf<CarouselItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        val carousel: ImageCarousel = findViewById(R.id.carousel)

        list.add(CarouselItem("https://images.squarespace-cdn.com/content/v1/5cae4c3f16b6407bf89ebeb4/1586547220129-YIDLO744DWCSZHUXK6OZ/IMG_1209.JPG",
        "El Panecillo"))
        list.add(CarouselItem("https://scontent.fuio1-2.fna.fbcdn.net/v/t1.6435-9/91392658_1879058692226599_1984225301059600384_n.jpg?_nc_cat=101&ccb=1-5&_nc_sid=8bfeb9&_nc_ohc=UhCwiorit5IAX-2jtcF&_nc_ht=scontent.fuio1-2.fna&oh=00_AT-ds9_yZhIuf61-T2r6mUdwYJMcUezHfae6el4hRiVlgA&oe=6235DD3D",
        "La Gran Cocina Típica"))
        list.add(CarouselItem("https://www.swissotel.es/assets/0/92/2119/2236/2275/2277/6442451815/6453a6fd-5e59-4539-bd1c-353abc9228e9.jpg",
        "Hotel Swissôtel Quito "))
        list.add(CarouselItem("https://quiteñisimo.com/wp-content/uploads/2021/05/parque-la-carolina-quito.jpg",
        "Parque la Carolina"))



        carousel.carouselListener = object : CarouselListener {


            override fun onClick(position: Int, carouselItem: CarouselItem) {
                Toast.makeText(this@Inicio, "Auto:${carouselItem.caption}", Toast.LENGTH_SHORT )
            }

            override fun onLongClick(position: Int, dataObject: CarouselItem) {
                // ...
            }


    }
        carousel.addData(list)
    }
}