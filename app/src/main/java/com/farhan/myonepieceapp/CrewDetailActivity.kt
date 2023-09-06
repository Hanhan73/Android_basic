package com.farhan.myonepieceapp

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class CrewDetailActivity : AppCompatActivity(), View.OnClickListener {

    companion object{
        const val EXTRA_CREW = "extra_crew"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crew_detail)

        val ivCrewPhoto:ImageView = findViewById(R.id.iv_photo)
        val tvCrewName:TextView = findViewById(R.id.tv_name)
        val tvCrewRole:TextView = findViewById(R.id.tv_role)
        val tvCrewDesc:TextView = findViewById(R.id.tv_desc)
        val btnShare: Button = findViewById(R.id.action_share)

        btnShare.setOnClickListener(this)
        val crew = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra<Crew>(EXTRA_CREW, Crew::class.java)
        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Crew>(EXTRA_CREW)
        }

        if (crew != null){
            Glide.with(this)
                .load(crew.photo)
                .into(ivCrewPhoto)
            tvCrewName.text = crew.name.toString()
            tvCrewRole.text = crew.role.toString()
            tvCrewDesc.text = crew.description.toString()
        }

    }

    override fun onClick(v: View?) {
        val message = "Kamu Memilih Crew Ini"
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, message)
            type = "text/plain"
        }
        if (sendIntent.resolveActivity(packageManager) != null) {
            startActivity(sendIntent)
        }
        }
}
