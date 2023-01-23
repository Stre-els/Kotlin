package com.example.labworkinformatika

import android.media.ImageWriter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class PrimerViewFragment : Fragment() {

    lateinit var imageView: ImageView
    lateinit var textX: TextView
    lateinit var editTextX: EditText
    lateinit var textY: TextView
    lateinit var editTextY: EditText
    lateinit var textAnswer: TextView

    lateinit var buttonAnswer: Button
    lateinit var buttonBack: Button

    var steps = ExampleClass()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_primer_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createView()
        buttonAnswer.setOnClickListener {
            when(formulaId) {
                0 -> textAnswer.text = steps.step1(editTextX.text.toString().toDouble(), editTextY.text.toString().toDouble())
                1 -> textAnswer.text = steps.step2(editTextX.text.toString().toDouble(), editTextY.text.toString().toDouble())
                2 -> textAnswer.text = steps.step3(editTextX.text.toString().toDouble(), editTextY.text.toString().toDouble())
                3 -> textAnswer.text = steps.step4(editTextX.text.toString().toDouble(), editTextY.text.toString().toDouble())
            }
        }

        buttonBack.setOnClickListener {
            activity?.onBackPressed()
        }

        isPrimer()
    }

    fun isPrimer() {
        when(formulaId) {
            0 -> imageView.setImageResource(R.drawable.formula_1)
            1 -> imageView.setImageResource(R.drawable.formula_2)
            2 -> {
                imageView.setImageResource(R.drawable.formula_3)
                textY.text = "Z:"
            }
            3 -> {
                imageView.setImageResource(R.drawable.formula_4)
                textX.text = "A:"
                textY.text = "B:"
            }
        }
    }

    fun createView() {
        imageView = view?.findViewById(R.id.imageView2)!!
        textX = view?.findViewById(R.id.textViewX)!!
        textY = view?.findViewById(R.id.textViewY)!!
        editTextX = view?.findViewById(R.id.editXtext)!!
        editTextY = view?.findViewById(R.id.editYtext)!!
        textAnswer = view?.findViewById(R.id.textViewAnswer)!!

        buttonAnswer = view?.findViewById(R.id.buttonAnswer)!!
        buttonBack = view?.findViewById(R.id.buttonPrimerBack)!!
    }
}