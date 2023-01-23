package com.example.myapplication

class MySetMenuClass {
    private var step: Int = 0
    private var listSet = MySet()
    fun setStep(value: Int) {
        step = value
    }

    fun getListStep() = listSet.returnSet()

    fun choice(element: String): String? {
        try {
            when(step) {
                0 -> listSet.myAdd(element)
                1 -> return ("element: ${listSet.myElement(element)}")
                2 -> return ("index element: ${listSet.myElementAt(element.toInt())}")
                3 -> listSet.myRemove(element)
                4 -> listSet.myRemoveAt(element.toInt())
                5 -> listSet.myUnion(element.split(" "))
                6 -> return listSet.clearMySet()
            }
        } catch (e: java.lang.Exception) {
            return e.localizedMessage
        }

        return null
    }
}

val myStep = MySetMenuClass()