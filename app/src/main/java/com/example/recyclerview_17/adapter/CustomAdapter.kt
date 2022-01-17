package com.example.recyclerview_17.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview_17.R
import com.example.recyclerview_17.model.Player

class CustomAdapter(val context: Context, val players: ArrayList<Player>) :
    RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val player = players[position]

        if (holder is ItemViewHolder) {
            holder.apply {
                Glide.with(context).load(player.imgURL).error(R.drawable.ic_launcher_foreground)
                    .into(playerPhoto)
                playerName.text = player.name
                playerPlace.text = "${player.country}, ${player.city}"
            }
        }
    }

    override fun getItemCount(): Int {
        return players.size
    }
}