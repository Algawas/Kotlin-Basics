package com.example.operatorsandconditions

fun main(){
    /*
    Assignment 1: What is the result of the following?
    Operator       -> Result
-------------------------------
    false && false -> False
    10 % 3         -> 1
    5 >= 5         -> True
    false || true  -> True
    5 - 3 * 2      -> -1             (PEDMAS)
    3 != 2         -> True
    (6 + 6) / 3    -> 4
    ###############################################
*/

/*
    Assignment 2
    Q1: Write a for loop that runs from 0 to 100 and once
    it's at 71 it should print "IT'S OVER 70!!!" and then exit the loop
    ###################################################
     */
    for(i in 0..100)
        if(i == 71) {
            println("IT'S OVER 70!!!")
            break
        }else{
            println("Power level is $i")
        }

println("##########################") //For readability

    /*    Assignment 2
    Q2: The temperature variable is initialized with 35. Write a
        while loop that checks temperature of the room and decrease the temperature by 1 every
        iteration until 10.
        print "It’s Hot" when the temperature is 30
        print "It’s Comfy" when the temperature is 20
        print "IT'S COLD!!!" when the temperature is 15
        else print just the temperature value
        ###################################################
      */
    var temp = 35
    while(temp!=9){
        when(temp){
            30 ->{
                println("It’s Hot")
            }
            20 ->{
                println("It’s Comfy")
            }
            15->{
                println("IT'S COLD!!!")
            }
            else->{
                println("Temprature is currently $temp")
            }
        }
        temp--
    }


}