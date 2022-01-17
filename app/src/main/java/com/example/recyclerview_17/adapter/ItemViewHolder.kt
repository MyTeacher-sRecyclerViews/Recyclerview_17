package com.example.recyclerview_17.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_17.R

class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val playerPhoto = itemView.findViewById<ImageView>(R.id.iv_item_picture)
    val playerName = itemView.findViewById<TextView>(R.id.tv_item_name)
    val playerPlace = itemView.findViewById<TextView>(R.id.tv_item_description)
}