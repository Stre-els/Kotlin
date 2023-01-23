package com.example.testrecyclerview

import androidx.navigation.NavController

class NewsClass(val titleNews: String,
                val textNews: String,
                val dataNewsPublish: String) {
    var textNewsShort: String = textNews.substring(0, 10) + "..."
}
