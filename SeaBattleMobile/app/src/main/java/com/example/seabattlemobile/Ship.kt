package com.example.seabattlemobile

import android.graphics.drawable.GradientDrawable.Orientation

class Deck(
    val x: Int,
    val y: Int,
    var status: Char,) {
}

class Ship(
    val listDeck: List<Deck>,
    val orientation: Char) {
    var lengthShip: Int = listDeck.size

    fun attackShip(x: Int, y: Int) {
        for (i in 0 until lengthShip) {
            if(listDeck[i].x == x && listDeck[i].y == y) {
                when(listDeck[i].status) {
                    'f' -> listDeck[i].status = 'p'
                    'l' -> listDeck[i].status = 'i'
                    's' -> listDeck[i].status = 'q'
                    else -> listDeck[i].status = 'x'
                }
            }
        }
    }

    fun statusShip(): String {
        var countDestroy = 0
        for(i in 0 until lengthShip) {
            if(listDeck[i].status == 'x' || listDeck[i].status == 'p' || listDeck[i].status == 'q' || listDeck[i].status == 'i') {
                countDestroy++
            }
            println("STATUS " + listDeck[i].status)
        }
        println(countDestroy)
        return when(countDestroy) {
            0 ->  "intact"
            in 1 until lengthShip -> "damaged"
            lengthShip -> "destroyer"
            else -> "unknown"
        }
    }
}
