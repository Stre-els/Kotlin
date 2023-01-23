package com.example.testrecyclerview

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

class AddNewFragment : Fragment() {

    lateinit var textTitleText: TextView
    lateinit var textNewsText: TextView
    lateinit var buttonAddNews: Button
    lateinit var textData: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_new, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewCreate()

        buttonAddNews.setOnClickListener {
            val date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.YYYY"))
            mutableListNews.add(NewsClass(
                textTitleText.text.toString(),
                textNewsText.text.toString(),
                date.toString()))

            Toast.makeText(view.context, "Новость добавлена", Toast.LENGTH_SHORT).show()
        }
    }

    fun viewCreate() {
        buttonAddNews = view?.findViewById(R.id.buttonAddNews)!!
        textTitleText = view?.findViewById(R.id.editNameNews)!!
        textNewsText = view?.findViewById(R.id.editTextText)!!
    }
}