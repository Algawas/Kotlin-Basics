package com.example.arraysandfunctions

import kotlin.random.Random

/*
Write a program that adds five Numbers (Double) to an array and then
calculates the average of those numbers.
Note: Please use a for (in) loop in this exercise.
*/
fun main(){
    var doubleArr = arrayListOf<Double>()
    var avg = 0.0
    while(doubleArr.size != 5) doubleArr.add(Random.nextDouble()) //Create 5 random doubles
    println("doubleArr is: $doubleArr")

    for(i in doubleArr){ // Combine the avg
        avg += i
        println("Total is currently: $avg")
    }
    //avg /= doubleArr.size
    println("The Average is ${avg/doubleArr.size}")
    // println("${avg /= doubleArr.size}") can't use this, you can't assign in print

}