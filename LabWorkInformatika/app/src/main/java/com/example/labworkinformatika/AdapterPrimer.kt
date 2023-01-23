package com.example.labworkinformatika

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class AdapterPrimer: RecyclerView.Adapter<AdapterPrimer.ViewHolder>() {

    val listPrimer = mutableListOf<Int>()

    fun setData(listPrimer: List<Int>) {
        this.listPrimer.clear()
        this.listPrimer.addAll(listPrimer)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(listPrimer[position])

        holder.moreButton.setOnClickListener {
            navController.navigate(R.id.primerViewFragment)
            formulaId = position
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.formula_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listPrimer.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var moreButton: ImageButton

        init {
            imageView = itemView.findViewById(R.id.imageView)
            moreButton = itemView.findViewById(R.id.buttonMore)
        }
    }
}