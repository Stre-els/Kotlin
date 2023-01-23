package com.example.seabattlemobile

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterBattleLog: RecyclerView.Adapter<AdapterBattleLog.ViewHolder>() {

    val listMessage = mutableListOf<Messager>()
    @SuppressLint("NotifyDataSetChanged")
    fun addData(message: Messager) {
        this.listMessage.add(message)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listMessage: List<Messager>) {
        this.listMessage.clear()
        this.listMessage.addAll(listMessage)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textId.text = (position+1).toString()
        holder.textPlayerId.text = listMessage[position].player
        holder.textMessage.text = listMessage[position].message
    }

    override fun getItemCount(): Int {
        return this.listMessage.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.battel_log_item, parent, false)
        return ViewHolder(itemView)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var textId: TextView
        var textPlayerId: TextView
        var textMessage: TextView
        init {
            textId = itemView.findViewById(R.id.textViewId)
            textPlayerId = itemView.findViewById(R.id.textViewPlayer)
            textMessage = itemView.findViewById(R.id.textViewMessage)
        }
    }

    class Messager(var player: String, var message: String)
}