package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AdaperOptionSet: RecyclerView.Adapter<AdaperOptionSet.ViewHolder>() {

    val listOptionSet = mutableListOf<OptionSet>()

    fun setData(listOptionSet: List<OptionSet>) {
        this.listOptionSet.clear()
        this.listOptionSet.addAll(listOptionSet)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listOptionSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtNameOption?.text = listOptionSet[position].optionName
        holder.txtOptionDescription?.text = listOptionSet[position].optionDescription

        holder.btnLayout?.setOnClickListener {
            myStep.setStep(position)
            Toast.makeText(holder.itemView.context, "your chose ${listOptionSet[position].optionName}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_option_item, parent, false)
        return  ViewHolder(itemView)
    }

    class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {
        var txtNameOption: TextView? = null
        var txtOptionDescription: TextView? = null
        var btnLayout: LinearLayout? = null

        init {
            txtNameOption = itemView?.findViewById(R.id.mainTextOptionItem)!!
            txtOptionDescription = itemView?.findViewById(R.id.descriptionOptionItem)!!
            btnLayout = itemView?.findViewById(R.id.clickLayout)
        }
    }
}