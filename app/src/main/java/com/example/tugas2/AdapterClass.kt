package com.example.tugas2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class AdapterClass (
    private  val dataList: ArrayList<DataClass>,
    private val listener:(DataClass) -> Unit
    ): RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {
    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView){
        val rvImages : ImageView = itemView.findViewById(R.id.images)
        val rvTitels : TextView = itemView.findViewById(R.id.Titles)
        val rvDesc : TextView = itemView.findViewById(R.id.descriptions)
        val btnDet : Button = itemView.findViewById(R.id.btn_detail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cardlist, parent, false)
        return ViewHolderClass(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.btnDet.setOnClickListener(){
            listener(dataList[position])
        }
        holder.rvImages.setImageResource(currentItem.dataImage)
        holder.rvTitels.text = currentItem.dataTitle
        holder.rvDesc.text = currentItem.dataDesc

    }

    override fun getItemCount(): Int {
        return  dataList.size
    }


}