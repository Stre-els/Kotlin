package com.example.testrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback

class MostInfNewsFragment : Fragment() {
    lateinit var buttonBack: Button
    lateinit var textTitle: TextView
    lateinit var textNews: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_most_inf_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createView()

        buttonBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    fun createView() {
        buttonBack = view?.findViewById(R.id.buttonBack)!!
        textTitle = view?.findViewById(R.id.titleTextMostInfNews)!!
        textNews = view?.findViewById(R.id.mainTextMostInfNews)!!

        textTitle.text = mutableListNews[newsId].titleNews
        textNews.text = mutableListNews[newsId].textNews
    }
}