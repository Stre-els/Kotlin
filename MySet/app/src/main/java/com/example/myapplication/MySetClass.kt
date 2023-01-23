package com.example.myapplication

class MySet {
    private val listSet = mutableListOf<String>()

    fun returnSet() = listSet

    fun myElement(element: String): String {
        for(i in listSet.indices) {
            if(listSet[i] == element)
                return i.toString()
        }
        return "element not allowed"
    }

    fun clearMySet(): String {
        listSet.clear()
        return "press to \"Enter\" your set clear"
    }

    fun myElementAt(index: Int): String {
        if(index >= 0 && index < listSet.size) {
            return  listSet[index]
        }
        return "index not allowed"
    }

    fun myRemove(element: String) {
        var a = -1
        for(i in listSet.indices) {
            if(listSet[i] == element) {
                a = i
            }
        }
        if(a != -1)
            listSet.removeAt(a)
    }

    fun myRemoveAt(index: Int) {
        if(index >= 0 && index < listSet.size) {
            listSet.removeAt(index)
        }
    }

    fun myAdd(element: String) {
        var i = 0
        listSet.forEach {
            if(it == element){
                i++
            }
        }
        if(i == 0) {
            listSet.add(element)
        }
    }

    fun myUnion(list: List<String>) {
        list.forEach {
            myAdd(it)
        }
    }
}