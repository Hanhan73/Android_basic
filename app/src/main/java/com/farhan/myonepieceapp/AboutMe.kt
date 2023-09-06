package com.farhan.myonepieceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class AboutMe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        val imageView = findViewById<ImageView>(R.id.imageView)


        Glide.with(this)
            .load(R.drawable.about_me_photo) // Replace with the actual image URL or resource
            .circleCrop()
            .into(imageView)
    }
}