package com.example.tugas2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Detail_Materi : AppCompatActivity() {
    private lateinit var imgMateri: ImageView
    private lateinit var txtJudulMateri: TextView
    private lateinit var txtDeskripsiMateri: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_materi)

        imgMateri = findViewById(R.id.img)
        txtJudulMateri = findViewById(R.id.tit)
        txtDeskripsiMateri = findViewById(R.id.des)

        // Mengambil data dari intent
        val image = intent.getIntExtra("image", 0)
        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")

        // Menampilkan data
        imgMateri.setImageResource(image)
        txtJudulMateri.text = title
        txtDeskripsiMateri.text = desc
    }
}