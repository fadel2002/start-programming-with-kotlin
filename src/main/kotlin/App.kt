/* Modul Memulai Pemrograman Dengan Kotlin */

/* Function Anatomy
private fun sum(valueA: Int, valueB: Int): Int
{
    return valueA + valueB
}

// Function Header
private fun sum(valueA: Int, valueB: Int): Int

// Function Body
{
    return valueA + valueB
}

// Function Name
fun

// Function Parameter
(valueA: Int, valueB: Int)

// Function Return Type
...): Int
* */

import kotlin.random.Random
fun main (){
//    Sub_Modul_Kotlin_Fundamental()
//    Sub_Modul_Control_Flow()
//    Sub_Modul_Data_Class_And_Collection()
    Sub_Modul_Kotlin_Functional_Programming()
}
/* Type Alias */
//typealias Arithmetic = ((Int, Int) -> Int)
typealias Arithmetic = ((Int, Int) -> Int)?

/* Class */
class User(val name : String, val age : Int){
    override fun toString(): String {
        return "User(name=$name, age=$age)"
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (name != other.name) return false
        if (age != other.age) return false

        return true
    }
    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age
        return result
    }
}
data class DataUser(val name : String, val age : Int){
    fun intro(){
        println("My name is $name, I am $age years old")
    }
}

val Int?.slice: Int
    get() = this?.div(2) ?: 0

/* Enum */
enum class Color(val value: Int) {
    RED(0xFF0000){
        override fun printValue() {
            println("value of RED is $value")
        }
    },
    GREEN(0x00FF00){
        override fun printValue() {
            println("value of GREEN is $value")
        }
    },
    BLUE(0x0000FF){
        override fun printValue() {
            println("value of BLUE is $value")
        }
    };
    abstract fun printValue()
}

/* Function */
fun Sub_Modul_Kotlin_Functional_Programming(){
    fun getListUser():MutableList<User> = mutableListOf<User>(User("fadel", 10), User("aurel", 11), User("arfa", 3))
    fun getUsername(list :MutableList<User>): List<String>{
        val name = mutableListOf<String>()
        for (user in list){
            name.add(user.name)
        }
        return name
    }

    val list:MutableList<User> = getListUser()
    println(getUsername(list))

    fun getFullName(
        first: String = "Kotlin",
        middle: String = " is ",
        last: String = "Awesome"): String {
        return "$first $middle $last"
    }

    println(getFullName())

    fun sets(name: String, vararg number: Int): Int {
        return number.size
    }

    print(sets("kotlin", 10, 20, 30))

    val number = intArrayOf(10, 20, 30, 40)
    println(sets("kotlin",10, 20, 20, *number , 10))

    fun Int.plusThree(): Int {
        return this + 3
    }
    println(10.plusThree())

    println(10.slice) // class

    val nullVal:Int? = null
    println(nullVal.slice)

    val sum: Arithmetic = { valueA, valueB -> valueA + valueB }
    val multiply: Arithmetic = { valueA, valueB -> valueA * valueB }
//    println("${sum(5,2)} ${multiply(5,2)}")
//    println("${sum.invoke(5,2)} ${multiply.invoke(5,2)}")
    println("${sum?.invoke(5,2)} ${multiply?.invoke(5,2)}")

    val message = { println("Hello From Lambda") }
    message()

    val printMessage = { message: String -> println(message) }
    printMessage("Hello From Lambda")

    var sumLambda: (Int, Int) -> Int = { value1, value2 -> value1 + value2 + 1 }
    println(sumLambda(10, 5))

    printResult(10){ value1, value2 ->
        value1 + value2 + 1
    }
    printResult(10 ,sumLambda)

    // menggunakan Domain specific languages (DSL) untuk meringkas kode yang berulang
    fun buildString(action: StringBuilder.() -> Unit): String {
        val stringBuilder = StringBuilder()
        stringBuilder.action()
        return stringBuilder.toString()
    }
}

// keyword inline disini agar saat di compile instansi dari fungsi yang di deklarasi tidak berulang
// sehingga waktu compile akan lebih cepat
inline fun printResult(value: Int, sum: (Int, Int) -> Int) {
    val result = sum(value, value)
    println(result)
}

fun Sub_Modul_Data_Class_And_Collection(){
    val user = User("nrohmen", 17)
    val dataUser = DataUser("nrohmen", 17)

    println(user)
    println(dataUser)

    // data class sudah memiliki beberapa build-in function tidak seperti class biasa
    val dataUser2 = DataUser("nrohmen", 17)
    val dataUser3 = DataUser("dimas", 24)
    println(dataUser.equals(dataUser2))
    println(dataUser.equals(dataUser3))

    val user2 = User("nrohmen", 17)
    val user3 = User("dimas", 24)
    println(user.equals(user2))
    println(user.equals(user3))

    val dataUser4 = dataUser.copy()
    println(dataUser4)

    val dataUser5 = dataUser.copy(age = 18)
    println(dataUser5)

    var name = dataUser.component1()
    var age = dataUser.component2()
    println("My name is $name, I am $age years old")

    var ( namee, agee ) = dataUser
    println("My name is $namee, I am $agee years old")

    dataUser.intro()

    val numberList : List<Int> = listOf(1, 2, 3, 4, 5)
    val charList = listOf('a', 'b', 'c')
    val anyList = listOf('a', "Kotlin", 3, true)
    println(anyList[3])

    val anyMutableList = mutableListOf('a', "Kotlin", 3, true, User("hei", 19))
    anyMutableList.add('d') // menambah item di akhir list
    anyMutableList.add(1, "love") // menambah item pada indeks ke-1
    anyMutableList[3] = false // mengubah nilai item pada indeks ke-3
    anyMutableList.removeAt(0) // menghapus item pada indeks ke-0

    val integerSet = setOf(1, 2, 4, 2, 1, 5)
    println(integerSet)

    val setA = setOf(1, 2, 4, 2, 1, 5)
    val setB = setOf(1, 2, 4, 5)
    println(setA == setB)

    println(5 in setA)

    val setC = setOf(1, 5, 7)
    val union = setA.union(setC)
    val intersect = setA.intersect(setC)

    println(union)
    println(intersect)

    val capital = mapOf(
        "Jakarta" to "Indonesia",
        "London" to "England",
        "New Delhi" to "India"
    );println(capital["Jakarta"])

    val mutableCapital = capital.toMutableMap()
    mutableCapital.put("Amsterdam", "Netherlands")
    mutableCapital.put("Berlin", "Germany")
    println(mutableCapital["Berlin"])

    val myNumberList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evenList = myNumberList.filter { it % 2 == 0 }
    println(evenList)

    val notEvenList = myNumberList.filterNot { it % 2 == 0 }
    println(notEvenList)

    val multipliedBy5 = myNumberList.map { it * 5 }
    println(multipliedBy5)

    println(myNumberList.count())
    println(myNumberList.count { it % 3 == 0 })

    val firstOddNumber = myNumberList.find { it % 2 == 1 }
    val firstOrNullNumber = myNumberList.firstOrNull { it % 2 == 0 }
    val lastOrNullNumber = myNumberList.lastOrNull { it % 2 == 1 }
    println("$firstOddNumber $firstOrNullNumber $lastOrNullNumber")

    val total = myNumberList.sum()
    println(total)

    val kotlinChar = listOf('k', 'o', 't', 'l', 'i', 'n')
    val ascendingSort = kotlinChar.sorted()
    val descendingSort = kotlinChar.sortedDescending()
    println("$ascendingSort $descendingSort")

    val list = (1..1000000).toList()
//    list.filter { it % 5 == 0 }.map { it * 2 }.forEach { println(it) } // akan disimpan didalam map terlebih dahulu kemduian di print
//    list.asSequence().filter { it % 5 == 0 }.map { it * 2 }.forEach { println(it) } // di komputasi kemudian di print di console terlebih dahulu kemudian lanjut index berikutnya

    val sequenceNumber = generateSequence(1) { it + 1 }
    sequenceNumber.take(5).forEach { print("$it ") }
}

fun Sub_Modul_Control_Flow(){

    val colorRed = Color.RED
    val colorGreen = Color.GREEN
    val colorBlue = Color.BLUE

    colorRed.printValue()
    colorGreen.printValue()
    colorBlue.printValue()

    val colors: Array<Color> = Color.values()
    colors.forEach { color ->
        print("$color: ${color.value}\n")
    }

    val color: Color = enumValueOf("RED")
    println("Color is $color")

    when(color){
        Color.RED -> println("Color is Red")
        Color.BLUE -> println("Color is Blue")
        Color.GREEN -> println("Color is Green")
    }

    println(sum(1 , 2 * 4))

    var value = 7
    val stringOfValue = when (value) {
        6 -> {
            println("Six")
            "value is 6"
        }
        7 -> {
            println("Seven")
            "value is 7"
        }
        8 -> {
            println("Eight")
            "value is 8"
        }
        else -> {
            println("undefined")
            "value cannot be reached"
        }
    }
    println(stringOfValue)

    value =  27
    val ranges = 10..50
    when(value){
        in ranges -> println("value is in the range")
        !in ranges -> println("value is outside the range")
        else -> println("value undefined")
    }

    val registerNumber = when(val regis = getRegisterNumber()){
        in 1..50 -> {println(regis); 50 * regis }
        in 51..100 -> {println(regis); 100 * regis }
        else -> {println(regis); regis}
    }
    println(registerNumber)

    val anyType: Any = 100L
    when (anyType) {
        is Long -> println("the value has a Long type")
        is Int -> println("the value has a Int type")
        is Double -> println("the value has a Double type")
        else -> println("undefined")
    }

    var counter = 1
    while (counter <= 7){
        println("Hello, World!")
        counter++
    }

    val rangeInt = 1..10 step 2
    rangeInt.forEach {
        print("$it ")
    }
    println(rangeInt.step)

    val rangeChar = 'A'.rangeTo('F')
    rangeChar.forEach {
        print("$it ")
    };println()

    val rangess = 1.rangeTo(10) step 3
    for ((index, value) in rangess.withIndex()) {
        println("value $value with index $index")
    }
    rangess.forEachIndexed { index, value ->
        println("value $value with index $index")
    }

    loop@ for (i in 1..10) {
        println("Outside Loop")

        for (j in 1..10) {
            println("Inside Loop")
            if ( j > 5) break@loop
        }
    }
}

fun getRegisterNumber() = Random.nextInt(100)

fun sum(value1: Int, value2: Int):Int = value1 + value2

fun Sub_Modul_Kotlin_Fundamental(){
    val x = 1
    println(x)

    var y = 1
    y = 2
    println(y)

    val firstWord = "Dicoding "
    val lastWord = "Academy"
    println(firstWord + lastWord)

    val valueA: Int = 10
    val valueB = 20
    println(valueA + valueB)

    var vocal = 'A'

    println("Vocal " + vocal++)
    println("Vocal " + vocal++)
    println("Vocal " + vocal++)
    println("Vocal " + vocal--)
    println("Vocal " + vocal--)
    println("Vocal " + vocal--)
    println("Vocal " + vocal--)
    println("Vocal " + vocal)

    val text  = "Kotlin"
    val firstChar = text[0]

    println("First character of $text is $firstChar")

    for (ch in text){
        print("$ch ")
    }; println()

    val unicode = "Unicode test: \u0031"
    println(unicode)

    var line = "Line 1\nLine 2\nLine 3\nLine 4"

    println(line)

    line = """
        Line 1
        Line 2
        Line 3
        Line 4
    """.trimIndent()

    println(line)

    println(setUser1("fadel", 10))

    println(setUser2("fadel", 10))

    val openHours = 7
    val now = 20
    if (now > openHours){
        println("office already open")
    }

    var office: String
    office = if (now > openHours) {
        "Office already open"
    } else {
        "Office is closed"
    }

    print(office)

    val officeOpen = 7
    val officeClosed = 16

    var isOpen = if (now >= officeOpen && now <= officeClosed){
        true
    } else {
        false
    }
    print("Office is open : $isOpen\n")

    isOpen = now >= officeOpen && now <= officeClosed
    print("Office is open : $isOpen\n")

    val byteNumber: Byte = 10
    val intNumber: Int = byteNumber.toInt() // ready to go
    println(intNumber)

    val array = arrayOf(1, 3, 5, 7)
    println(array)

    val mixArray = arrayOf(1, 3, 5, 7 , "Dicoding" , true)
    println(mixArray)

    var nullVar: String? = null // ready to go
    println(nullVar)

    println(nullVar?.length)

    println(nullVar?.length ?: 7)

    nullVar = "tes"
    println(nullVar?.length ?: 7)

    val hour = 7
    print("Office ${if (hour > 7) "already close" else "is open"}")

    println()
}

fun setUser1(name: String, age: Int): String {
    return "Your name is $name, and you $age years old"
}

fun setUser2(name: String, age: Int): String = "Your name is $name, and you $age years old"
