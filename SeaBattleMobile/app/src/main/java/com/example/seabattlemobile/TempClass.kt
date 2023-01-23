package com.example.seabattlemobile

import androidx.navigation.NavController


class TempClass {


    companion object {
        //4-x палубный корабль
        val decks4Ship1 = listOf<Deck>(
            Deck(1, 0, 'f'),
            Deck(2, 0, '+'),
            Deck(3, 0, '+'),
            Deck(4, 0, 'l'),)

        //3-x палубный корабль
        val decks3Ship1 = listOf<Deck>(
            Deck(0, 2, 'f'),
            Deck(0, 3, '+'),
            Deck(0, 4, 'l'),)

        //3-x палубный корабль
        val decks3Ship2 = listOf<Deck>(
            Deck(0, 6, 'f'),
            Deck(0, 7, '+'),
            Deck(0, 8, 'l'),)

        //2-x палубный корабль
        val decks2Ship1 = listOf<Deck>(
            Deck(2, 3, 'f'),
            Deck(3, 3, 'l'),)

        //2-x палубный корабль
        val decks2Ship2 = listOf<Deck>(
            Deck(8, 3, 'f'),
            Deck(8, 4, 'l'),)

        //2-x палубный корабль
        val decks2Ship3 = listOf<Deck>(
            Deck(4, 8, 'f'),
            Deck(4, 9, 'l'),)

        //4-x палубный корабль
        val decks1Ship1 = listOf<Deck>(
            Deck(5, 5, 's'),)

        //4-x палубный корабль
        val decks1Ship2 = listOf<Deck>(
            Deck(6, 1, 's'),)

        //4-x палубный корабль
        val decks1Ship3 = listOf<Deck>(
            Deck(9, 9, 's'),)

        //4-x палубный корабль
        val decks1Ship4 = listOf<Deck>(
            Deck(2, 7, 's'),)

        val ships = mutableListOf<Ship>()
            /*Ship(decks4Ship1, 'v'),
            Ship(decks3Ship1, 'h'), Ship(decks3Ship2, 'h'),)*/
        val ships2 = mutableListOf<Ship>()
            /*Ship(decks2Ship1, 'v'), Ship(decks2Ship2, 'h'), Ship(decks2Ship3, 'h'),)
        Ship(decks2Ship1, 'v'), Ship(decks2Ship2, 'h'), Ship(decks2Ship3, 'v'),
        Ship(decks2Ship1, 'h'), Ship(decks4Ship1, 'v'), Ship(decks1Ship3, 'v'), Ship(decks1Ship4, 'v'))*/

        lateinit var NavController: NavController
        var mapPlayer1: Map = Map(ships)
        var mapPlayer2: Map = Map(ships2)
        var adapterLog = AdapterBattleLog()

        fun addLog(player: String, message: String): AdapterBattleLog.Messager {
            return AdapterBattleLog.Messager(player, message)
        }
    }
}