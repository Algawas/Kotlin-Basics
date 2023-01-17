/**
Write a program in which you are assigning those values to variables with the right (specific) data type
"Abdullah"
20.6F
8.9746325
25
2022
321984526954
true
'a'
Note: both val and var are correct, and Kotlin does NOT require a semicolon
 */
fun main() {
    val name: String = "Abdullah"
  	val float: Float = 20.6F //Note, even if you specify float you MUST add the F
    val double: Double = 8.9746325
    val age: Byte = 25 //While int, short and long are correct, Byte is the MOST correct because it's most efficient
    val year: Short = 2022
    val long: Long = 321984526954L
    val bool: Boolean = true
    val char: Char = 'a'
    
    
    println(name)
    println(float)
    println(double)
    println(age)
    println(year)
    println(long)
    println(bool)
    println(char)
}
