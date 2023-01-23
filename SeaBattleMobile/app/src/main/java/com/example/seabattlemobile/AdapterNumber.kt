package com.example.seabattlemobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterNumber: RecyclerView.Adapter<AdapterNumber.ViewHoler>() {

    val list = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    override fun onBindViewHolder(holder: ViewHoler, position: Int) {
        holder.textViewNumber.text = list[position].toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoler {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.number_item, parent,false)
        return ViewHoler(itemView)
    }
    override fun getItemCount(): Int {
        return 10
    }
    class ViewHoler(itemView: View): RecyclerView.ViewHolder(itemView) {
        var textViewNumber: TextView
        init {
            textViewNumber = itemView.findViewById(R.id.textViewNumber)
        }
    }
}