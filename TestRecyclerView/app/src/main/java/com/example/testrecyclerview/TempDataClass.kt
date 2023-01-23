package com.example.testrecyclerview

import androidx.navigation.NavController

    lateinit var navigationController: NavController
    var newsId: Int = 0
    val mutableListNews: MutableList<NewsClass> = mutableListOf(
        NewsClass("news one", "description news one", "01.12.2022"),
        NewsClass("News Two", "Today 1 december", "01.12.2022"))
