package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterSetItem: RecyclerView.Adapter<AdapterSetItem.ViewHolder>() {

    val listSet = mutableListOf<String>()

    fun setData(listSet: List<String>) {
        this.listSet.clear()
        this.listSet.addAll(listSet)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.set_item, parent, false)
        return ViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textIndex?.text = " $position. "
        holder.textValue?.text = listSet[position]
    }

    override fun getItemCount(): Int {
        return listSet.size
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var textIndex: TextView? = null
        var textValue: TextView? = null

        init {
            textIndex = itemView?.findViewById(R.id.textIndex)
            textValue = itemView?.findViewById(R.id.textValue)
        }
    }
}