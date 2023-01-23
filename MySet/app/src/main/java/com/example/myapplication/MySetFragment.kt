package com.example.myapplication

import android.graphics.Region.Op
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.concurrent.thread

class MySetFragment : Fragment(), View.OnClickListener {

    lateinit var viewSet: RecyclerView
    lateinit var viewSetOption: RecyclerView
    lateinit var editText: EditText
    lateinit var buttonEnter: Button
    lateinit var buttonBack: Button



    val listOption = listOf(
        OptionSet("Add", "Add element to Set"),
        OptionSet("Element", "Return index to value"),
        OptionSet("ElementAt", "Return element in Index"),
        OptionSet("Remove", "Delete element to value"),
        OptionSet("RemoveAt", "Delete element to index"),
        OptionSet("Union", "union two set"),
        OptionSet("Clear", "clear your set",)
    )

    private var adaperOptionSet = AdaperOptionSet()
    private var adapterSet = AdapterSetItem()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_set, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createView()
        buttonBack.setOnClickListener(this)
        buttonEnter.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.btnEnterStr -> enterNewParam()
            R.id.btnBack -> stepBack()
        }
    }

    fun enterNewParam() {
        var message: String? = null
        if(editText.text.toString() != "") {
            val newValue = editText.text.toString()
            message = myStep.choice(newValue)
            adapterSet.setData(myStep.getListStep())
            editText.text.clear()
        } else {
            message = "Enter to value"
        }

        message?.let {
            Toast.makeText(view?.context, message, Toast.LENGTH_SHORT).show()
        }
    }

    fun stepBack() {
        activity?.supportFragmentManager?.popBackStack()
    }

    fun createView() {
        viewSet = view?.findViewById(R.id.viewSet)!!
        viewSetOption =view?.findViewById(R.id.viewSetOption)!!
        editText = view?.findViewById(R.id.editText)!!
        buttonEnter = view?.findViewById(R.id.btnEnterStr)!!
        buttonBack = view?.findViewById(R.id.btnBack)!!

        viewSetOption.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewSetOption.adapter = adaperOptionSet
        adaperOptionSet.setData(listOption)

        viewSet.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewSet.adapter = adapterSet
        adapterSet.setData(myStep.getListStep())
    }
}