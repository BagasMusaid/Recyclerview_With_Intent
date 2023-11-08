package com.example.tugas2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var RV : RecyclerView
    private lateinit var dataList : ArrayList<DataClass>

    lateinit var imageList : Array<Int>
    lateinit var titleList : Array<String>
    lateinit var descList : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageList = arrayOf(
            R.drawable.java1,
            R.drawable.java2,
            R.drawable.java3,
            R.drawable.java4,
            R.drawable.java5
        )
        titleList = arrayOf(
            "Konsep Pemograman Java",
            "Fungsi Input dan Output",
            "Tipe Data Java",
            "Operator Dasar",
            "Percabangan di Java"
        )
        descList = arrayOf(
            "Pemrograman adalah proses yang dilakukan untuk membuat program komputer.",
            "Seperti yang kita ketahui, program komputer terdiri dari tiga komponen utama, yaitu: input, proses, dan output.",
            "Tipe data adalah jenis data yang tersimpan dalam variabel.",
            "Operator dalam pemrograman digunakan untuk melakukan operasi tertentu.",
            "Percabangan hanyalah sebuah istilah yang digunakan untuk menyebut alur program yang bercabang."
        )
        RV = findViewById(R.id.RV_card)
        RV.layoutManager = LinearLayoutManager(this)
        RV.setHasFixedSize(true)
        dataList = arrayListOf<DataClass>()
        getData()
        val adapter = AdapterClass(dataList){selectedItems ->
            val it = Intent(this, Detail_Materi::class.java).apply{
                putExtra("image", selectedItems.dataImage)
                putExtra("title", selectedItems.dataTitle)
                putExtra("desc", selectedItems.dataDesc)
            }
            startActivity(it)
        }
        RV.adapter = adapter
    }

    private fun getData() {
        for (i in imageList.indices){
            val dataClass = DataClass(imageList[i],titleList[i],descList[i])
            dataList.add(dataClass)
        }
    }
}