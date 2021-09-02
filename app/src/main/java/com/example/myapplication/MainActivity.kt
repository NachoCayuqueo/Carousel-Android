package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import me.relex.circleindicator.CircleIndicator2
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.listener.CarouselOnScrollListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class MainActivity : AppCompatActivity() {

    private val list = mutableListOf<CarouselItem>()
    private var itemCarousel: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val carousel: ImageCarousel = findViewById(R.id.carousel)
        val indicator = findViewById<CircleIndicator2>(R.id.custom_indicator)
        val button = findViewById<Button>(R.id.buttonID)

        list.add(CarouselItem(R.drawable.coliseo_roma,"Coliseo Romano"))
        list.add(CarouselItem(R.drawable.cristo_redentor,"Cristo Redentor"))
        list.add(CarouselItem(R.drawable.gran_muralla_china,"Muralla China"))
        list.add(CarouselItem(R.drawable.machu_picchu,"Machu Picchu"))
        list.add(CarouselItem(R.drawable.petra,"Petra"))
        list.add(CarouselItem(R.drawable.taj_mahal,"Taj Mahal"))
        list.add(CarouselItem(R.drawable.piramide_de_chichen_itza,"Piramide de Chichen Itza"))

        carousel.carouselListener = object: CarouselListener{
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                Toast.makeText(this@MainActivity,"CLICK EN: ${carouselItem.caption}",Toast.LENGTH_SHORT).show()
            }

            override fun onLongClick(position: Int, dataObject: CarouselItem) {
                Toast.makeText(this@MainActivity,"CLICk PRONUNCIADO EN: ${dataObject.caption}",Toast.LENGTH_SHORT).show()
            }

        }

        carousel.onScrollListener = object: CarouselOnScrollListener{
            override fun onScrollStateChanged(
                recyclerView: RecyclerView,
                newState: Int,
                position: Int,
                carouselItem: CarouselItem?
            ) {
                itemCarousel = carouselItem?.caption
            }
        }

        button.setOnClickListener {
            println("CLICK CON: $itemCarousel")
        }

        carousel.addData(list)
        carousel.setIndicator(indicator)
    }
}