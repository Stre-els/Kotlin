package com.example .seabattlemobile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.seabattlemobile.TempClass.Companion.addLog

class BattleFragment : Fragment() {
    lateinit var viewMap: RecyclerView
    lateinit var viewX: RecyclerView
    lateinit var viewY: RecyclerView
    lateinit var viewBattleLog: RecyclerView
    lateinit var editTextX: EditText
    lateinit var editTextY: EditText
    lateinit var buttonFire: Button
    lateinit var buttonViewMap: Button
    lateinit var buttonEndStep: Button
    lateinit var textPlayer: TextView

    var playerId = 1
    var adapterSea = AdapterSea()
    var adaperXY = AdapterNumber()
    var isVisibleMap = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_battle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadComponent(view)

        loadMap(2, false)
        buttonViewMap.setOnClickListener {
            when(playerId) {
                1 -> if(isVisibleMap) {
                    loadMap(1, true)
                    isVisibleMap = false
                } else {
                    loadMap(2, false)
                    isVisibleMap = true
                }
                2 -> if(isVisibleMap) {
                    loadMap(2, true)
                    isVisibleMap = false
                } else {
                    loadMap(1, false)
                    isVisibleMap = true
                }
            }
        }
        adapterSea.attachDelegate(object: BattleInterface {
            @SuppressLint("SetTextI18n")
            override fun playerStep() {
                if(!adapterSea.lastHit) {
                    if (playerId == 1) {
                        playerId = 2
                        textPlayer.text = "Player $playerId"
                        loadMap(1, false)
                    } else {
                        playerId = 1
                        textPlayer.text = "Player $playerId"
                        loadMap(2, false)
                    }
                }
                TempClass.adapterLog.addData(addLog("Player: $playerId", "STEP"))
            }

            override fun endGame() {
                TempClass.NavController.navigate(R.id.mainMenuFragment)
            }
        })
    }

    private fun loadMap(player: Int, isVisible: Boolean) {
        if(player == 1) {
            adapterSea.setVisible(isVisible)
            adapterSea.setMap(TempClass.mapPlayer2, 2)
        } else {
            adapterSea.setVisible(isVisible)
            adapterSea.setMap(TempClass.mapPlayer1, 1)
        }
    }

    private fun loadComponent(view: View) {
        viewX = view.findViewById(R.id.recyclerViewNumberX)
        viewX.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        viewX.adapter = adaperXY

        viewY = view.findViewById(R.id.recyclerViewNumberY)
        viewY.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        viewY.adapter = adaperXY

        viewMap = view.findViewById(R.id.viewPositionShipPlayer)
        viewMap.layoutManager = GridLayoutManager(view.context, 10)
        viewMap.adapter = adapterSea

        buttonViewMap = view.findViewById(R.id.buttonViewMyMap)

        textPlayer = view.findViewById(R.id.textViewIsPlayer)

        viewBattleLog = view.findViewById(R.id.viewBattleLog)
        viewBattleLog.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        viewBattleLog.adapter = TempClass.adapterLog
        TempClass.adapterLog.addData(addLog("Player: 1", "Ready battle"))
        TempClass.adapterLog.addData(addLog("Player: 2", "Ready battle"))
        TempClass.adapterLog.addData(addLog("Player: 1", "STEP"))
    }

}