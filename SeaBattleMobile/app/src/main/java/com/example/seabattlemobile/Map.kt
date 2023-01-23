package com.example.seabattlemobile

class Map(
    val ships: MutableList<Ship>
) {
    val map = mutableListOf<MutableList<Char>>()
    init {
        for(i in 0..10) {
            map.add(mutableListOf('0', '0', '0', '0', '0', '0', '0', '0', '0', '0'))
        }
        addShip()
    }

    private fun addShip() {
        for(i in ships.indices) {
            for(j in 0 until ships[i].lengthShip) {
                map[ships[i].listDeck[j].x][ships[i].listDeck[j].y] = ships[i].listDeck[j].status
            }
        }

    }

    fun isShip(x: Int, y: Int): Int {
        for(i in ships.indices) {
            for(j in ships[i].listDeck.indices) {
                if(ships[i].listDeck[j].x == x && ships[i].listDeck[j].y == y) {
                    return i
                }
            }
        }
        return -1
    }
}