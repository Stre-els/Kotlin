package com.example.testrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListNewFragment : Fragment() {

    val adapterNews = AdapterNews()
    lateinit var recyclerViewNews: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_new, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapterNews.attachDelegate(object: OpenNewsInterface {
            override fun openNews(position: Int) {
                open()
                newsId = position
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createView()
    }

    fun open() {
        navigationController.navigate(R.id.mostInfNewsFragment)
    }

    fun createView() {
        recyclerViewNews = view?.findViewById(R.id.recyclerViewNews)!!
        recyclerViewNews.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerViewNews.adapter = adapterNews
        adapterNews.setData(mutableListNews)
    }
}