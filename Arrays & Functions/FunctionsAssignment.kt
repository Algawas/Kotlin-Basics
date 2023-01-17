package com.example.arraysandfunctions

fun main(){
    arithmetic(1.943141, 1.0)
    arithmetic(1.943141, 2.0, "-")
    arithmetic(1.943141, 3.0, "*")
    arithmetic(1.943141, 4.0, "/")
    arithmetic(1.943141, 5.0, "Peekaboo")

}

/*Write a program that do the following:
Write a function that accepts three parameters, two parameters of type doubles
and one with parameter of type string. the string parameters has a default a argument of
"+". the string parameter only accepts these arguments "+", "-", "*" and "/".
check what is the value of the string and then do the corresponding mathematical operation.
*/

fun arithmetic(num1: Double, num2: Double, operation: String = "+") {
    when (operation){
        "+" -> println("$num1 $operation $num2 = ${num1+num2}")
        "-" -> println("$num1 $operation $num2 = ${num1-num2}")
        "*" -> println("$num1 $operation $num2 = ${num1*num2}")
        "/" -> println("$num1 $operation $num2 = ${num1/num2}")
        else -> print("Unknown operation, please choose either +, -, * or /")
    }
}