import kotlin.random.Random
import kotlin.math.PI

fun main() {

    /**
     * Zadanie 1
     * You have a list of “green” numbers and a list of “red” numbers. Complete the code to print how many numbers there are in total.
     *
     * fun main() {
     * val greenNumbers = listOf(1, 4, 23)
     * val redNumbers = listOf(17, 2)
     * // Write your code here
     * }
     *
     */
    fun zadanie1() {
        val greenNumbers = listOf(1, 4, 23)
        val redNumbers = listOf(17, 2)
        println((greenNumbers.count() + redNumbers.count()))
    }

    /**
     * Zadanie 2
     * Explicitly declare the correct type for each variable:
     *
     * fun main() {
     * val a: Int = 1000
     * val b = "log message"
     * val c = 3.14
     * val d = 100_000_000_000_000
     * val e = false
     * val f = '\n'
     * }
     *
     */
    fun zadanie2(){
        val a: Int = 1000
        val b: String = "log message"
        val c: Double = 3.14
        val d: Long = 100_000_000_000_000
        val e: Boolean = false
        val f: Char = '\n'
    }

    /**
     * Zadanie 3
     * You have a set of protocols supported by your server. A user requests to use a particular protocol. Complete the program to check whether the requested protocol
     * is supported or not (isSupported must be a Boolean value).
     *
     * fun main() {
     * val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
     * val requested = "smtp"
     * val isSupported = // Write your code here
     * println("Support for $requested: $isSupported")
     */
    fun zadanie3(){
            val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
            val requested = "smtp"
            val isSupported = requested.uppercase() in SUPPORTED
                println("Support for $requested: $isSupported")
    }

    /**
     * Zadanie 4
     * Define a map that relates integer numbers from 1 to 3 to their corresponding spelling. Use this map to spell the given number
     *
     * fun main() {
     * val number2word = // Write your code here
     * val n = 2
     * println("$n is spelt as '${<Write your code here >}'")
     * }
     */
    fun zadanie4(){
            val number2word = mapOf(1 to "one", 2 to "two", 3 to "three")
            val n = 2
            println("$n is spelt as '${number2word[n]}'")
    }

    /**
     * Zadanie 5
     * Create a simple game where you win if throwing two dice results in the same number. Use if to print You win :) if the dice match or You lose :( otherwise.
     *
     * import kotlin.random.Random
     * fun main() {
     * val firstResult = Random.nextInt(6)
     * val secondResult = Random.nextInt(6)
     * // Write your code here
     * }
     */
    fun zadanie5(){

            val firstResult = Random.nextInt(6)
            val secondResult = Random.nextInt(6)
        if (firstResult == secondResult){
            println("You win :)")
        } else {
            println("You lose :(")
        }
    }

    /**
     * Zadanie 6
     * Using a when expression, update the following program so that it prints the corresponding actions when you input the names of game console buttons.
     *
     * Button Action
     * A Yes
     * B No
     * X Menu
     * Y Nothing
     * Other There is no such button
     *
     * fun main() {
     * val button = "A"
     * println(
     * // Write your code here
     * )
     * }
     *
     */
    fun zadanie6() {
        val button = "A"
        println(
            when(button) {
                "A" -> "Yes"
                "B" -> "No"
                "X" -> "Menu"
                "Y" -> "Nothing"
                else -> "There is no such buton"
            }
        )
    }

    /**
     * Zadanie 7
     * You have a program that counts pizza slices until there’s a whole pizza with 8 slices. Refactor this program in two ways:
     * Use a while loop.
     * Use a do-while loop.
     *
     * fun main() {
     * var pizzaSlices = 0
     * // Start refactoring here
     * pizzaSlices++
     * println("There's only $pizzaSlices slice/s of pizza :(")
     * pizzaSlices++
     * println("There's only $pizzaSlices slice/s of pizza :(")
     * pizzaSlices++
     * println("There's only $pizzaSlices slice/s of pizza :(")
     * pizzaSlices++
     * println("There's only $pizzaSlices slice/s of pizza :(")
     * pizzaSlices++
     * println("There's only $pizzaSlices slice/s of pizza :(")
     * pizzaSlices++
     * println("There's only $pizzaSlices slice/s of pizza :(")
     * pizzaSlices++
     * println("There's only $pizzaSlices slice/s of pizza :(")
     * pizzaSlices++
     * // End refactoring here
     * println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
     * }
     */
    fun zadanie7a(){
            var pizzaSlices = 0
        while(pizzaSlices < 7) {
            pizzaSlices++
            println("There's only $pizzaSlices slice/s of pizza :(")
        }
        pizzaSlices++
        println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
    }
    fun zadanie7b(){
        var pizzaSlices = 0
        do{
            pizzaSlices++
            println("There's only $pizzaSlices slice/s of pizza :(")
        } while(pizzaSlices < 7)
        pizzaSlices++
        println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
    }

    /**
     * Zadanie 8
     * Write a program that simulates the Fizz buzz game. Your task is to print numbers from 1 to 100 incrementally, replacing any number divisible by three with the word
     * "fizz", and any number divisible by five with the word "buzz". Any number divisible by both 3 and 5 must be replaced with the word "fizzbuzz".
     * Hint 1
     * Use a for loop to count numbers and a when expression to decide what to print at each step.
     * Hint 2
     * Use the modulo operator (%) to return the remainder of a number being divided. Use the equality operator (==) to check if the remainder equals zero.
     *
     */
    fun zadanie8(){
        for(number in 1 .. 100){
            println(
                when {
                    number % 3 == 0 -> "fizz"
                    number % 5 == 0 -> "buzz"
                    number % 15 == 0 -> "fizzbuzz"
                    else -> "$number"
                }
            )
        }
    }

    /**
     * Zadanie 9
     * You have a list of words. Use for and if to print only the words that start with the letter l.
     *
     * fun main() {
     * val words = listOf("dinosaur", "limousine", "magazine", "language")
     * // Write your code here
     * }
     *
     */
    fun zadanie9(){
        val words = listOf("dinosaur", "limousine", "magazine", "language")
        for (w in words){
            if (w.startsWith("l"))
                println(w)
        }
    }

    /**
     * Zadanie 10
     * Write a function called circleArea that takes the radius of a circle in integer format as a parameter and outputs the area of that circle
     *
     * import kotlin.math.PI
     * // Write your code here
     * fun main() {
     * println(circleArea(2))
     * }
     */
    fun zadanie10(radius: Int) {
        println(PI * radius * radius)
    }

    /**
     * Zadanie 11
     * Rewrite the circleArea function from the previous exercise as a single-expression function.
     *
     */
    fun zadanie11(radius: Int) = println(PI * radius * radius)

    /**
     * Zadanie 12
     * You have a function that translates a time interval given in hours, minutes, and seconds into seconds. In most cases, you need to pass only one or two function
     * parameters while the rest are equal to 0. Improve the function and the code that calls it by using default parameter values and named arguments so that the code is
     * easier to read.
     *
     * fun intervalInSeconds(hours: Int, minutes: Int, seconds: Int) =
     * ((hours * 60) + minutes) * 60 + seconds
     * fun main() {
     * println(intervalInSeconds(1, 20, 15))
     * println(intervalInSeconds(0, 1, 25))
     * println(intervalInSeconds(2, 0, 0))
     * println(intervalInSeconds(0, 10, 0))
     * println(intervalInSeconds(1, 0, 1))
     * }
     */
    fun zadanie12(hours: Int = 0, minutes: Int = 0, seconds: Int = 0) = ((hours * 60) + minutes) * 60 + seconds

    zadanie1()
    zadanie3()
    zadanie4()
    zadanie5()
    zadanie6()
    zadanie7a()
    zadanie7b()
    zadanie8()
    zadanie9()
    zadanie10(5)
    zadanie11(3)
    println(zadanie12(1, 20, 15))
    println(zadanie12(minutes = 1, seconds = 25))
    println(zadanie12(hours = 2))
    println(zadanie12(minutes = 10))
    println(zadanie12(hours = 1, seconds = 1))
}