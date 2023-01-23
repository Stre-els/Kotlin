package com.example.seabattlemobile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StartGameFragment : Fragment() {
    lateinit var viewStartPositionShip: RecyclerView
    lateinit var viewNumberX: RecyclerView
    lateinit var viewNumberY: RecyclerView
    lateinit var positionX: EditText
    lateinit var positionY: EditText
    lateinit var orientationShip: Switch
    lateinit var buttonStartGame: Button
    lateinit var buttonAddShip: Button
    lateinit var textDeckShip: TextView
    lateinit var textIsPlayer: TextView
    lateinit var adapter: AdapterSea

    var listShip = mutableListOf<Ship>()
    var orientation = 'h'
    val listShipDeck = listOf<Int>(
        4,
        3, 3,)
        //2, 2, 2,)
        /*1, 1, 1, 1, 0)*/
    var itemNumberListShipDeck = 0
    var isPlayer = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_game, container, false)
    }

    @SuppressLint("ResourceAsColor", "SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadComponent(view)
        addMapShip(view)

        buttonStartGame.setOnClickListener {
            if(isPlayer == 1) {
                textIsPlayer.text = "Player 2"
                itemNumberListShipDeck = 0
                isPlayer = 2
                textDeckShip.text = "${listShipDeck[itemNumberListShipDeck]} Deck"
                buttonStartGame.isEnabled = false
                buttonAddShip.isEnabled = true
                TempClass.mapPlayer2 = Map(listShip)
            } else {
                TempClass.mapPlayer1 = Map(listShip)
                TempClass.NavController.navigate(R.id.battleFragment)
            }
            adapter.clearMap()
            listShip = mutableListOf<Ship>()
        }
    }

    private fun addMapShip(view: View) {
        buttonAddShip.setOnClickListener {
            val ship = createShip(view)
            listShip.add(ship)
            adapter.addShip(ship)
            updateText()
        }

        orientationShip.setOnCheckedChangeListener { _, check ->
            orientation = if(check) {
                Toast.makeText(view.context, "Select Vertical", Toast.LENGTH_SHORT).show()
                'v'
            }
            else {
                Toast.makeText(view.context, "Select Horizontal", Toast.LENGTH_SHORT).show()
                'h'
            }
        }
    }

    private fun createShip(view: View): Ship {
        var y: Int = positionX.text.toString().toInt()-1
        var x: Int = positionY.text.toString().toInt()-1
        val ship = mutableListOf<Deck>()
        for (i in 0 until listShipDeck[itemNumberListShipDeck]) {
            var status = when(i) {
                0 -> 'f'
                listShipDeck[itemNumberListShipDeck]-1 -> 'l'
                else -> '+'
            }
            if(listShipDeck[itemNumberListShipDeck] == 1)
                status = 's'
            if(orientation == 'v') {
                println("Deck($x, $y \'$status\')")
                ship.add(Deck(x++, y, status))
            }
            else
                ship.add(Deck(x,y++, status))
        }
        println(orientation)
        return Ship(ship, orientation)
    }

    @SuppressLint("SetTextI18n")
    private fun updateText() {
        itemNumberListShipDeck++
        textDeckShip.text = "${listShipDeck[itemNumberListShipDeck]} Deck"
        if(itemNumberListShipDeck == listShipDeck.size-1) {
            textDeckShip.text = "Ready"
            buttonStartGame.isEnabled = true
            buttonAddShip.isEnabled = false
        }
    }

    @SuppressLint("SetTextI18n")
    private fun loadComponent(view: View) {
        viewStartPositionShip = view.findViewById(R.id.viewPositionShipPlayer)
        adapter = AdapterSea()

        viewStartPositionShip.layoutManager = GridLayoutManager(view.context, 10)
        viewStartPositionShip.adapter = adapter

        textDeckShip = view.findViewById(R.id.deckShipCount)
        textDeckShip.text = "${listShipDeck[itemNumberListShipDeck]} Deck"
        positionX = view.findViewById(R.id.editTextX)
        positionY = view.findViewById(R.id.editTextY)
        buttonAddShip = view.findViewById(R.id.addShipButton)
        buttonStartGame = view.findViewById(R.id.startGameButton)
        orientationShip = view.findViewById(R.id.selectOrientationShip)
        textIsPlayer = view.findViewById(R.id.textViewIsPlayer)

        val adapterNumber = AdapterNumber()
        viewNumberX = view.findViewById(R.id.recyclerViewNumberX)
        viewNumberX.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        viewNumberX.adapter = adapterNumber
        viewNumberY = view.findViewById(R.id.recyclerViewNumberY)
        viewNumberY.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        viewNumberY.adapter = adapterNumber
    }
}