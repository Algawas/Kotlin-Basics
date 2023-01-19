package com.algawas.xmlassignment

import androidx.lifecycle.ViewModel



class MainViewModel : ViewModel() {
    var counter = 0
    private set


    fun checkValue(): String{
        return if(counter<0) "EY NO NEGATIVES HERE: $counter"
        else counter.toString()
    }

    fun negative(): String{
        counter--
        return checkValue()
    }

    fun positive(): String{
        counter++
        return checkValue()
    }
}