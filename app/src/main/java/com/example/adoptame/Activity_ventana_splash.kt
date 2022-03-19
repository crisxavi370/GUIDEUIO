package com.example.adoptame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils;
import kotlinx.android.synthetic.main.activity_pantalla_splash.*

class Activity_ventana_splash : AppCompatActivity() {

    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_splash)

        background_image.animation = AnimationUtils.loadAnimation(this, R.anim.side_anim)
        powered_by_line.animation = AnimationUtils.loadAnimation(this, R.anim.slide_animation)

        handler = Handler()
        handler.postDelayed({
            // Delay and Start Activity
            val intent = Intent(this, Activity_onboarding::class.java)
            startActivity(intent)
            finish()
        } , 3000) // here we're delaying to startActivity after 3seconds

    }
}