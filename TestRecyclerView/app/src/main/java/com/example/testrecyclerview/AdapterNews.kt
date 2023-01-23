package com.example.testrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

interface OpenNewsInterface {
    fun openNews(position: Int)
}

class AdapterNews: RecyclerView.Adapter<AdapterNews.ViewHolder>() {

    private val listNews: MutableList<NewsClass> = mutableListOf()

    var delegate: OpenNewsInterface? = null

    fun attachDelegate(delegate: OpenNewsInterface) {
        this.delegate = delegate
    }

    fun setData(listNews: List<NewsClass>){
        this.listNews.clear()
        this.listNews.addAll(listNews)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textNewTitle.text = listNews[position].titleNews
        holder.textNewsShort.text = listNews[position].textNewsShort
        holder.textDataPublish.text = listNews[position].dataNewsPublish

        holder.layoutItemNews.setOnClickListener {
            delegate?.openNews(position)
        }
    }

    override fun getItemCount(): Int {
        return listNews.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var textNewTitle: TextView
        var textNewsShort:  TextView
        var textDataPublish: TextView
        var layoutItemNews: ConstraintLayout

        init {
            textNewTitle = itemView.findViewById(R.id.textNewsTitle)
            textNewsShort = itemView.findViewById(R.id.textNews)
            textDataPublish = itemView.findViewById(R.id.textDatePublish)
            layoutItemNews = itemView.findViewById(R.id.layoutItemNews)
        }
    }
}