package com.example.labworkinformatika

import java.text.DecimalFormat
import kotlin.math.*
import kotlin.math.sqrt

class ExampleClass {
    var df = DecimalFormat("#.######")
    fun step1(x: Double, y: Double): String {
        val num1 = abs(x - 1).pow(1.0 / 2) - abs(y).pow((1.0 / 3.0))
        val num2 = 1 + (x.pow(2.0) /2) + (y.pow(2.0) /4)
        return df.format(num1/num2).toString()
    }

    fun step2(x: Double, y: Double): String {
        val num = 1 + ((x.pow(2))/(2*y))
        return df.format(x/num).toString()
    }

    fun step3(x: Double, y: Double): String {
        return df.format(x*(tan(y) + Math.E.pow(x+3))).toString()
    }

    fun step4(x: Double, y: Double): String {
        return df.format(3*sqrt(x+y)-7*sin(x)).toString()
    }
}