package com.example.labworkinformatika

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListPrimerFragment : Fragment() {

    lateinit var buttonBack: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_primer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createView()

        buttonBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    fun createView() {
        val adapter = AdapterPrimer()
        val recyclerView: RecyclerView = view?.findViewById(R.id.listPrimerView)!!

        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        adapter.setData(listFormuls)

        buttonBack = view?.findViewById(R.id.buttonBack)!!
    }
}