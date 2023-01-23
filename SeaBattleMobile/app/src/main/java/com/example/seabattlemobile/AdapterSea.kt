package com.example.seabattlemobile

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

interface BattleInterface {
    fun playerStep()
    fun endGame()
}

class AdapterSea: RecyclerView.Adapter<AdapterSea.ViewHolder>() {
    val ships = mutableListOf<Ship>()
    var playerMap: Map = Map(ships)
    var lastHit = false
    private var isVisible: Boolean = true
    private var delegate: BattleInterface? = null
    private var playerId = 0

    fun attachDelegate(delegate: BattleInterface) {
        this.delegate = delegate
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setVisible(isVisible: Boolean) {
        this.isVisible = isVisible
        notifyDataSetChanged()
    }
    @SuppressLint("NotifyDataSetChanged")
    fun clearMap() {
        this.ships.clear()
        val map = Map(ships)
        this.playerMap = map
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setMap(map: Map, playerId: Int) {
        this.playerId = playerId
        this.ships.addAll(map.ships)
        this.playerMap = map
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addShip(ship: Ship) {
        this.ships.add(ship)
        this.playerMap = Map(this.ships)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.sea_item, parent, false)
        return ViewHolder(itemView)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var x = position/10
        var y = position%10

        val numShip = playerMap.isShip(x, y)
            if (playerMap.map[x][y] != '0' && playerMap.map[x][y] != '*' && (isVisible || ships[numShip].statusShip() == "destroyer"))
                if(numShip != -1)
                    if(playerMap.ships[numShip].orientation == 'h')
                            holder.image.rotation = -90.0F
        /*
        * + - ship
        * s - small ship
        * f - start ship
        * l - end ship
        * x - damage ship
        * p - damage start ship
        * q - damage small ship
        * i - damage end ship
        * * - past
        * */
        holder.image.setOnClickListener {
            x = position/10
            y = position%10
            println("X $x Y $y")
            var shipNumber = -1
            when(playerMap.map[x][y]) {
                '+' -> {
                    shipNumber = playerMap.isShip(x, y)
                    playerMap.map[x][y] = 'x'
                    playerMap.ships[shipNumber].attackShip(x, y)
                    holder.image.setImageResource(R.drawable.sea_hit)
                }
                's' -> {
                    shipNumber = playerMap.isShip(x, y)
                    playerMap.map[x][y] = 'q'
                    playerMap.ships[shipNumber].attackShip(x, y)
                    holder.image.setImageResource(R.drawable.sea_hit)
                }
                'l' -> {
                    shipNumber = playerMap.isShip(x, y)
                    playerMap.map[x][y] = 'i'
                    playerMap.ships[shipNumber].attackShip(x, y)
                    holder.image.setImageResource(R.drawable.sea_hit)
                }
                'f' -> {
                    shipNumber = playerMap.isShip(x, y)
                    playerMap.map[x][y] = 'p'
                    playerMap.ships[shipNumber].attackShip(x, y)
                    holder.image.setImageResource(R.drawable.sea_hit)
                }
                else -> {
                    playerMap.map[x][y] = '*'
                    holder.image.setImageResource(R.drawable.sea_fire)
                }
            }

            holder.image.isEnabled = false
            lastHit = shipNumber != -1
            if(shipNumber != -1)
                TempClass.adapterLog.addData(TempClass.addLog("Player $playerId:", "Ship: ${ships[shipNumber].statusShip()}"))
            else
                TempClass.adapterLog.addData(TempClass.addLog("Player $playerId:", "Past! [$x][$y]"))
            isWin(holder)
            delegate?.playerStep()

            when(playerId) {
                1 -> TempClass.mapPlayer1 = playerMap
                2 -> TempClass.mapPlayer2 = playerMap
            }
        }

        when(playerMap.map[x][y]) {
            '+' -> {
                if(isVisible)
                    holder.image.setImageResource(R.drawable.ship)
                else
                    holder.image.setImageResource(R.drawable.sea)
            }
            's' -> {
                if(isVisible)
                    holder.image.setImageResource(R.drawable.ship_one)
                else
                    holder.image.setImageResource(R.drawable.sea)
            }
            'l' -> {
                if(isVisible)
                    holder.image.setImageResource(R.drawable.ship_end)
                else
                    holder.image.setImageResource(R.drawable.sea)
            }
            'f' -> {
                if(isVisible)
                    holder.image.setImageResource(R.drawable.ship_start)
                else
                    holder.image.setImageResource(R.drawable.sea)
            }
            'x' -> {
                if(isVisible || (numShip != -1 && ships[numShip].statusShip() == "destroyer")) {
                    holder.image.setImageResource(R.drawable.ship_destroy)
                }
                else
                    holder.image.setImageResource(R.drawable.sea_hit)
            }
            'p' -> {
                if(isVisible || (numShip != -1 && ships[numShip].statusShip() == "destroyer"))
                    holder.image.setImageResource(R.drawable.ship_start_destroy)
                else
                    holder.image.setImageResource(R.drawable.sea_hit)
            }
            'q' -> holder.image.setImageResource(R.drawable.ship_one_destroy)
            'i' -> {
                if(isVisible || (numShip != -1 && ships[numShip].statusShip() == "destroyer"))
                    holder.image.setImageResource(R.drawable.ship_end_destroy)
                else
                    holder.image.setImageResource(R.drawable.sea_hit)
            }
            '*' -> holder.image.setImageResource(R.drawable.sea_fire)
            else -> holder.image.setImageResource(R.drawable.sea)
        }
    }

    override fun getItemCount(): Int {
        return 100
    }

    private fun isWin(holder: ViewHolder) {
        var destroyShipCount = 0
        playerMap.ships.forEach {
            if(it.statusShip() == "destroyer")
                destroyShipCount++
        }
        if(destroyShipCount == playerMap.ships.size) {
            Toast.makeText(holder.itemView.context, "Win $playerId", Toast.LENGTH_SHORT).show()
            TempClass.adapterLog.addData(TempClass.addLog("Player $playerId:", "Winner!"))
            delegate?.endGame()
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        init {
            image = itemView.findViewById(R.id.imageView)
        }
    }
}