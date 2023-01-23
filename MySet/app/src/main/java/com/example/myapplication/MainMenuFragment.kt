package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class MainMenuFragment : Fragment(), View.OnClickListener {
    lateinit var btnNewSet: Button
    lateinit var btnExit: Button



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createView()
        btnNewSet.setOnClickListener(this)
        btnExit.setOnClickListener(this)
    }

    fun createView() {
        btnNewSet = view?.findViewById(R.id.btnStart)!!
        btnExit = view?.findViewById(R.id.btnExit)!!

    }

    fun onExit() {
        activity?.finishAndRemoveTask()
    }

    fun onNewSet() {
        val nextFragment = MySetFragment()
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container_view_tag, nextFragment, "newSet")
            ?.addToBackStack(null)
            ?.commit()
    }

    override fun onClick(p0: View?) {
        when(p0!!.id) {
            R.id.btnStart -> onNewSet()
            R.id.btnExit -> onExit()
        }
    }
}