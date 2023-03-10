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

// Import
import java.beans.Visibility
import kotlin.random.Random
import kotlin.reflect.KProperty
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sqrt
import kotlin.NumberFormatException
//import com.dicoding.oop.utils.*
import com.dicoding.oop.utils.PI as PI_P
import com.dicoding.oop.utils.factorial
import com.dicoding.oop.utils.pow
import com.dicoding.oop.utils.sayHello
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
import com.dicoding.coroutine.utils.pointer
import kotlinx.coroutines.channels.Channel

fun main (){
    val Sub_Modul_Kotlin_Functional_Programming = {
        /* Materi Sub Modul */
        Konsep_Functional_Programming()
        Named_And_Default_Argument()
        Vararg()
        Extension()
        Nullable_Receiver()
        Function_Type()
        Lambda()
        Higher_Order_Function()
        Lambda_With_Receiver()
        Kotlin_STL()
        Scope_Function_With_Lambda_Receiver()
        Scope_Function_With_Lambda_Argument()
        Member_Reference()
        Function_Inside_Function()
        Fold_Drop_Take()
        Slice_Distinct_Chuncked()
        Recursion()
    }
    val Sub_Modul_Kotlin_Object_Oriented_Programming = {
        /* Materi Sub Modul */
        Object_Everywhere()
        Class()
        Property()
        Property_Delegation()
        Extension_Properties()
        Primary_Constructor()
        Second_Constructor()
        Visibility_Modifiers()
        Inheritances()
        Overloading()
        Abstract_Class()
        Interfaces()
        Import_Dan_Packages()
        Membuat_Package_Baru()
        Exception_Handling()
    }
    val Sub_Modul_Kotlin_Generics = {
        /* Materi Sub Modul */
        Konsep_Generics_Pada_Kotlin()
        Mendeklarasikan_Kelas_Generics()
        Mendeklarasikan_Fungsi_Generics()
        Constraint_Type_Parameter()
        Variance()
    }
    val Sub_Modul_Coroutines = {
        /* Materi Sub Modul */
        Concurrency_Pada_Kotlin()
        Concurrency_VS_Parallelism()
        Process_Thread_IO_Bound()
        Deadlocks_Dan_Livelocks()
        Starvation_Dan_Race_Condition()
        Kotlin_Coroutines()
//        Memulai_Coroutines()
//        Coroutines_Builder()
        Job()
//        Menjalankan_Job_Baru()
        Membatalkan_Job()
//        Deffered()
        Coroutine_Dispacther()
        Channels()
    }

//    Sub_Modul_Kotlin_Fundamental()
//    Sub_Modul_Control_Flow()
//    Sub_Modul_Data_Class_And_Collection()
//    Sub_Modul_Kotlin_Functional_Programming()
//    Sub_Modul_Kotlin_Object_Oriented_Programming()
//    Sub_Modul_Kotlin_Generics()
//    Sub_Modul_Coroutines()

    Exam()
}

/* Global Variable */
var globalVar = "Kotlin"
val Int?.slice: Int
    get() = this?.div(2) ?: 0
val Animal.getAnimalInfo : String
    get() =  "Nama: ${this.name}, Berat: ${this.weight}, Umur: ${this.age} Mamalia: ${this.isMammal}"


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
data class Item(val key: String, val value: Any)
class Animal(var name: String, var weight: Double, var age: Int, var isMammal: Boolean)


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
fun Exam(){
    val char = "\t \n \" "
    println(char)

    var i = 3
    while (i > 0) {
        println(i)
        i--
    }
    println("Completed")

    fun doSomething(vararg input: Int): Int {
        return (input.sum() / input.size)
    }
    val result = doSomething(1, 2, 3, 4, 5)
    println(result)

    val total = listOf(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
    val result1 = total.distinct()
    val result2 = result1.slice(1..3)
    println(result2)

    fun Int.plusThree(): Int {
        return this + 3
    }
    println(10.plusThree())
}
fun Concurrency_Pada_Kotlin(){
    // TODO: https://www.dicoding.com/academies/80/tutorials/4266
}
fun Concurrency_VS_Parallelism(){
    // Perbedaan concurrency dan parallelism, tak kira sama ternyata berbeda
    // conccurency berdasar pengertianku, banyak proses yang dikerjakan secara bersamaan oleh satu objek(bisa orang, bisa cpu, etc)
    // TODO: https://www.dicoding.com/academies/80/tutorials/4269?from=4266
}
fun Process_Thread_IO_Bound(){
    // TODO: https://www.dicoding.com/academies/80/tutorials/4272?from=4269
}
fun Deadlocks_Dan_Livelocks(){
    // TODO: https://www.dicoding.com/academies/80/tutorials/4275?from=4272
}
fun Starvation_Dan_Race_Condition(){
    // Strarvation kondisi dimana satu proses mendapatkan banyak resources namun satunya tidak samsek
    // Race Condition kondisi dimana ketika suatu concurrency mau mengakses data yang sama dan ingin mengubahnya, sehingga tabrakan
    // TODO: https://www.dicoding.com/academies/80/tutorials/4281?from=4275
}
fun Kotlin_Coroutines(){
    // TODO: https://www.dicoding.com/academies/80/tutorials/4278?from=4281
}
fun Memulai_Coroutines() = runBlocking{
    launch {
        delay(1000L)
        println("Coroutines!")
        delay(1000L)
        println("This also not the end")
        delay(1000L)
        println("This the end")
    }
    println("Hello,")
    delay(2000L)
    println("This is not the end, isn't it ?")
}
fun Coroutines_Builder() = runBlocking {

    suspend fun getCapital(): Int {
        delay(500L)
        return 50000
    }
    suspend fun getIncome(): Int {
        delay(500L)
        return 75000
    }
    val sequentialTime = measureTimeMillis {
        // Sequential
        val capital = getCapital()
        val income = getIncome()
        println("Your profit is ${income - capital}")
    }

    val conccurencyTime = measureTimeMillis {
        // Conccurency
        val capital = async { getCapital() }
        val income = async { getIncome() }
        println("Your profit is ${income.await() - capital.await()}")
    }
    println("Completed in $sequentialTime ms vs $conccurencyTime ms")

}
fun Job(){
    // TODO: https://www.dicoding.com/academies/80/tutorials/4288?from=4285
}
fun Menjalankan_Job_Baru(){
    // start akan menjalankan println("Other task")
    fun func1() = runBlocking{
        val job = launch(start = CoroutineStart.LAZY) {
            delay(1000L)
            println("Start new job!")
        }
        job.start()
        println("Other task")
    }

    // join akan menunggu sampai job selesai kemudian menjalankan println("Other task")
    fun func2() = runBlocking{
        val job = launch(start = CoroutineStart.LAZY) {
            delay(1000L)
            println("Start new job!")
        }
        job.join()
        println("Other task")
    }
    func1()
    func2()
}

fun Membatalkan_Job() {
    // klik fungsi dibawah ini untuk melihat contoh pembatalan job
    pointer()
}
fun Deffered() = runBlocking{
    suspend fun getCapital(): Int {
        delay(500L)
        return 50000
    }
    suspend fun getIncome(): Int {
        delay(500L)
        return 75000
    }
    // variabel capital dan income disini merupakan contoh nilai defered
    val capital = async { getCapital() }
    val income = async { getIncome() }
    println("Your profit is ${income.await() - capital.await()}")
}
fun Coroutine_Dispacther(){
    // TODO: https://www.dicoding.com/academies/80/tutorials/4299?from=4297
}
fun Channels() = runBlocking(CoroutineName("main")){
    val channel = Channel<Int>()
    launch(CoroutineName("v1coroutine")){
        println("Sending from ${Thread.currentThread().name}")
        for (x in 1..5) {
            delay(500L)
            channel.send(x * x)
        }
    }

    repeat(5) { println(channel.receive()) }
    println("received in ${Thread.currentThread().name}")
}

fun Konsep_Generics_Pada_Kotlin(){
    // type variabel ditentukan secara explisit
    val contributors = listOf<String>("jasoet", "alfian","nrohmen","dimas","widy")
    // type variabel ditentukan oleh kompiler sebagai string
    val contributor = listOf("alfian","nrohmen","dimas","widy")
    // kompiler tidak bisa menentukan tipe variable karena tidak mempunyai data,
    // maka harus di sebutkan secara explisit
    val contribute = listOf<String>()
    // beberapa keyword bisa menggunakan >1 tipe variabel
    val points = mapOf<String, Int>( "alfian" to 10 , "dimas" to 20 )

    println(contributors)
    println(contributor)
    println(contribute)
    println(points)
}

fun Mendeklarasikan_Kelas_Generics(){
    // TODO: https://www.dicoding.com/academies/80/tutorials/4257
}
fun Mendeklarasikan_Fungsi_Generics(){
    val numbers = (1..100).toList()
    println(numbers.slice<Int>(1..10))

    // jika semua nilai memiliki tipe yang sama maka
    // kompiler akan menentukan tersebut
    println(numbers.slice(1..10))
}
fun Constraint_Type_Parameter(){
    // TODO: https://www.dicoding.com/academies/80/tutorials/4261?from=4258
}
fun Variance(){
    abstract class Vehicle(var wheel: Int){
        fun wheel(): Int{
            return wheel
        }
    }
    class Car(var speed: Int) : Vehicle(4){}
    class MotorCycle(var speed: Int) : Vehicle(2)

    val car = Car(200)
    val motorCycle = MotorCycle(100)
    var vehicle: Vehicle = car
    println(vehicle.wheel())
    vehicle = motorCycle
    println(vehicle.wheel())

    // penggunaan variance lainnya, agar object bisa di assign ke variabel lain
    val carList = listOf(Car(100) , Car(120))
    val vehicleList = carList
    println(vehicleList)
    println(carList)

    /* TODO: Covariant, Contravariant
        https://www.dicoding.com/academies/80/tutorials/4263?from=4261
    */

}

fun Object_Everywhere(){
    val someString = "Dicoding"
    println(someString.reversed())
    println(someString.toUpperCase())
    println(someString.toLowerCase())

    val someNumberString = "123"
    val someInt = someNumberString.toInt()
    val someOtherString = "12.34"
    val someDouble = someOtherString.toDouble()
    println(someInt is Int)
    println(someDouble is Double)
}

fun Class(){
    /*
        + name: String
        + weight: Double
        + age: Int
        + isMammal: Boolean
        - eat()
        - sleep()

        + merupakan properti
        - merupakan fungsi

        Class: Merupakan sebuah blueprint yang terdapat properti dan fungsi di dalamnya
        Properties: Karakteristik dari sebuah kelas, memiliki tipe data.
        Functions: Kemampuan atau aksi dari sebuah kelas.
   */

    class Animal(val name: String,
                 val weight: Double,
                 val age: Int,
                 val isMammal: Boolean
    ) {
        fun eat(){
            println("$name makan !")
        }
        fun sleep() {
            println("$name tidur !")
        }
    }

    val cat = Animal("Dicoding Miaw", 4.2, 2,true)
    println("Nama: ${cat.name}, Berat: ${cat.weight}, Umur: ${cat.age}, mamalia: ${cat.isMammal}" )
    cat.eat()
    cat.sleep()
}

fun Property(){
    class Animal{
        var name: String = "Dicoding Miaw"
            get(){
                println("Fungsi Getter terpanggil")
                return field
            }
            set(value){
                println("Fungsi Setter terpanggil")
                field = value
            }
    }

    val dicodingCat = Animal()
    println("Nama: ${dicodingCat.name}" )
    dicodingCat.name = "Goose"
    println("Nama: ${dicodingCat.name}")
}

fun Property_Delegation(){
    class DelegateName {
        private var value: String = "Default"
        operator fun getValue(classRef: Any?, property: KProperty<*>) : String {
            println("Fungsi ini sama seperti getter untuk properti ${property.name} pada class $classRef")
            return value
        }
        operator fun setValue(classRef: Any?, property: KProperty<*>, newValue: String){
            println("Fungsi ini sama seperti setter untuk properti ${property.name} pada class $classRef")
            println("Nilai ${property.name} dari: $value akan berubah menjadi $newValue")
            value = newValue
        }
    }
    class Animal {
        var name: String by DelegateName()
    }
    class Person {
        var name: String by DelegateName()
    }
    class Hero {
        var name: String by DelegateName()
    }

    val animal = Animal()
    animal.name = "Dicoding Miaw"
    println("Nama Hewan: ${animal.name}")

    val person = Person()
    person.name = "Dimas"
    println("Nama Orang: ${person.name}")

    val hero = Hero()
    hero.name = "Gatotkaca"
    println("Nama Pahlawan: ${hero.name}")

    class DelegateGenericClass {
        private var value: Any = "Default"
        operator fun getValue(classRef: Any, property: KProperty<*>): Any {
            println("Fungsi ini sama seperti getter untuk properti ${property.name} pada class $classRef")
            return value
        }
        operator fun setValue(classRef: Any, property: KProperty<*>, newValue: Any) {
            println("Nilai ${property.name} dari: $value akan berubah menjadi $newValue")
            value = newValue
        }
    }

    class Animal1 {
        var name: Any by DelegateGenericClass()
        var weight: Any by DelegateGenericClass()
        var age: Any by DelegateGenericClass()
    }

    val animal1 = Animal1()
    animal1.name = "Dicoding cat"
    animal1.weight = 6.2
    animal1.age = 1
    println("Nama: ${animal1.name}")
    println("Berat: ${animal1.weight}")
    println("Umur: ${animal1.age} Tahun")
}

fun Extension_Properties(){
    val dicodingCat = Animal("Dicoding Miaw", 5.0, 2, true)
    println(dicodingCat.getAnimalInfo)
}

fun Primary_Constructor(){
    class Animal(var name: String, var weight: Double, var age: Int = 0, var isMammal: Boolean = true)
    val dicodingCat = Animal("Dicoding Miaw", -2.9, -5)
    println("Nama: ${dicodingCat.name}, Berat: ${dicodingCat.weight}, Umur: ${dicodingCat.age}, mamalia: ${dicodingCat.isMammal}" )

    class AnimalWithValidation(name: String, weight: Double, age: Int, isMammal: Boolean) {
        val name: String
        val weight: Double
        val age: Int
        val isMammal: Boolean

        init {
            this.weight = if(weight < 0) 0.1 else weight
            this.age = if(age < 0) 0  else age
            this.name = name
            this.isMammal = isMammal
        }
    }
    val dicodingCatValid = AnimalWithValidation("Dicoding Miaw", -2.9, -5, true)
    println("Nama: ${dicodingCatValid.name}, Berat: ${dicodingCatValid.weight}, Umur: ${dicodingCatValid.age}, mamalia: ${dicodingCatValid.isMammal}")

}
fun Second_Constructor(){
    class Animal(name: String, weight: Double, age: Int) {
        val name: String
        val weight: Double
        val age: Int
        var isMammal: Boolean

        init {
            this.weight = if(weight < 0) 0.1 else weight
            this.age = if(age < 0) 0  else age
            this.name = name
            this.isMammal = false
        }

        constructor(name: String, weight: Double, age: Int, isMammal: Boolean) : this(name, weight, age) {
            this.isMammal = isMammal
        }
    }

    val dicodingCat = Animal("Dicoding Miaw", 2.5, 2, true)
    println("Nama: ${dicodingCat.name}, Berat: ${dicodingCat.weight}, Umur: ${dicodingCat.age}, mamalia: ${dicodingCat.isMammal}")

    val dicodingBird = Animal("Dicoding tweet", 0.5, 1)
    println("Nama: ${dicodingBird.name}, Berat: ${dicodingBird.weight}, Umur: ${dicodingBird.age}, mamalia: ${dicodingBird.isMammal}")

    class DefaultAnimal{
        val name: String = "Dicoding Miaw"
        val weight: Double = 4.2
        val age: Int = 2
        val isMammal: Boolean = true
    }
    val dicodingCatDefault = DefaultAnimal()
    println("Nama: ${dicodingCatDefault.name}, Berat: ${dicodingCatDefault.weight}, Umur: ${dicodingCatDefault.age}, mamalia: ${dicodingCatDefault.isMammal}" )
}
fun Visibility_Modifiers(){
    class Animal(private var name: String, private val weight: Double, private val age: Int, private val isMammal: Boolean = true) {
        fun getName() : String {
            return name
        }
        fun setName(newName: String) {
            name = newName
        }
    }
    val dicodingCat = Animal("Dicoding Miaw", 2.5, 2, true)
    println(dicodingCat.getName())
    dicodingCat.setName("Gooose")
    println(dicodingCat.getName())
}
fun Inheritances(){
    open class Animal(val name: String, val weight: Double, val age: Int, val isCarnivore: Boolean){
        open fun eat(){
            println("$name sedang makan!")
        }
        open fun sleep(){
            println("$name sedang tidur!")
        }
    }
    class Cat(pName: String, pWeight: Double, pAge: Int, pIsCarnivore: Boolean, val furColor: String, val numberOfFeet: Int)
        : Animal(pName, pWeight, pAge, pIsCarnivore) {
        fun playWithHuman() {
            println("$name bermain bersama Manusia !")
        }
        override fun sleep() {
            println("$name sedang tidur di bantal !")
        }
    }

    val dicodingCat = Cat("Dicoding Miaw", 3.2, 2, true, "Brown", 4)
    dicodingCat.playWithHuman()
    dicodingCat.eat()
    dicodingCat.sleep()
}
fun Overloading(){
    class Animal(private var name: String) {
        fun eat() {
            println("$name makan!")
        }
        fun eat(typeFood: String) {
            println("$name memakan $typeFood!")
        }
        fun eat(typeFood: String, quantity: Double) {
            println("$name memakan $typeFood sebanyak $quantity grams!")
        }
        fun sleep() {
            println("$name tidur!")
        }
    }
    val dicodingCat = Animal("Dicoding Miaw")

    dicodingCat.eat()
    dicodingCat.eat("Ikan Tuna")
    dicodingCat.eat("Ikan Tuna", 450.0)
}
fun Abstract_Class(){
    abstract class Animal(var name: String, var weight: Double, var age: Int, var isCarnivore: Boolean){
        fun eat(){
            println("$name sedang makan !")
        }
        fun sleep(){
            println("$name sedang tidur !")
        }
    }
    class Cat(pName: String, pWeight: Double, pAge: Int, pIsCarnivore: Boolean)
        : Animal(pName, pWeight, pAge, pIsCarnivore) {
    }
    val animal = Cat("dicoding animal", 2.6, 1, true)
    animal.eat()
    animal.sleep()
}
interface IFly {
    fun fly()
    val numberOfWings: Int
}
fun Interfaces(){

    class Bird(override val numberOfWings: Int) : IFly {
        override fun fly() {
            if(numberOfWings > 0) println("Flying with $numberOfWings wings")
            else println("I'm Flying without wings")
        }
    }
    fun flyWithWings(bird: IFly) {
        bird.fly()
    }

    flyWithWings(Bird(2))

    flyWithWings(object : IFly {
        override fun fly() {
            if(numberOfWings > 0) println("Flying with $numberOfWings wings")
            else println("I'm Flying without wings")
        }
        override val numberOfWings: Int
            get() = 2
    })
}
fun Import_Dan_Packages(){
    // lihat line 27
    println(PI)
    println(cos(120.0))
    println(sqrt(9.0))
}

fun Membuat_Package_Baru(){
    // TODO: https://www.dicoding.com/academies/80/tutorials/4336?from=4335
    sayHello()
    println(factorial(4.0))
    println(pow(3.0, 2.0))
    println(PI_P)
}
fun Exception_Handling(){
    fun exception(){
        val someValue = 6
        val someStringValue = "18.0"
        val someNullValue: String? = null
        val someMustNotNullValue: String = someNullValue!!

        // ArithmeticException
        println(someValue / 0)
        // NumberFormatException
        println(someStringValue.toInt())
        // NullPointerException
        println(someMustNotNullValue)
    }
//    exception()
    /*
        Q: !! is at the end of a statement?
            IJ auto-convert to Kotlin did that
            for me val price = sale.latest!!
        A: it means that sale.latest can contain null;
            the assignment will succeed only if sale.latest
            is not null and will throw NPE otherwise. This gives
            null-safety for val price: its type will be non-null
     */

    val someStringValue: String? = null
    var someIntValue: Int = 0

    try {
        someIntValue = someStringValue!!.toInt()
    } catch (e: NullPointerException) { // ketika try terjadi exception
        someIntValue = 0
    } catch (e: NumberFormatException) { // ketika catch diatas terjadi exception
        someIntValue = -1
    } finally { // di run jika terjadi exception maupun tidak
        when (someIntValue) {
            0 -> println("Catch block NullPointerException terpanggil !")
            -1 -> println("Catch block NumberFormatException terpanggil !")
            else -> println(someIntValue)
        }
    }
}

fun Konsep_Functional_Programming(){
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
}

fun Named_And_Default_Argument(){
    fun getFullName(
        first: String = "Kotlin",
        middle: String = " is ",
        last: String = "Awesome"): String {
        return "$first $middle $last"
    }
    println(getFullName())
}

fun Vararg(){
    fun sets(name: String, vararg number: Int): Int {
        return number.size
    }

    print(sets("kotlin", 10, 20, 30))

    val number = intArrayOf(10, 20, 30, 40)
    println(sets("kotlin",10, 20, 20, *number , 10))
}

fun Extension(){
    fun Int.plusThree(): Int {
        return this + 3
    }
    println(10.plusThree())

    println(10.slice) // class
}

fun Nullable_Receiver(){
    val nullVal:Int? = null
    println(nullVal.slice)
}

fun Function_Type(){
    val sum: Arithmetic = { valueA, valueB -> valueA + valueB }
    val multiply: Arithmetic = { valueA, valueB -> valueA * valueB }
//    println("${sum(5,2)} ${multiply(5,2)}")
//    println("${sum.invoke(5,2)} ${multiply.invoke(5,2)}")
    println("${sum?.invoke(5,2)} ${multiply?.invoke(5,2)}")
}
fun Lambda(){
    val message = { println("Hello From Lambda") }
    message()

    val printMessage = { message: String -> println(message) }
    printMessage("Hello From Lambda")
}
fun Higher_Order_Function(){
    var sumLambda: (Int, Int) -> Int = { value1, value2 -> value1 + value2 + 1 }
    println(sumLambda(10, 5))

    printResult(10){ value1, value2 ->
        value1 + value2 + 1
    }
    printResult(10 ,sumLambda)
}

fun Lambda_With_Receiver(){
    fun buildStringManual(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("Hello ")
        stringBuilder.append("from ")
        stringBuilder.append("lambda")
        return stringBuilder.toString()
    }
    println(buildStringManual())

    // menggunakan Domain specific languages (DSL) untuk meringkas kode yang berulang
    fun buildStringDsl(action: StringBuilder.() -> Unit): String {
        val stringBuilder = StringBuilder()
        stringBuilder.action()
        return stringBuilder.toString()
    }

    val messageConcat = buildStringDsl {
        append("Hello ")
        append("from ")
        append("lambda ")
    }
    println(messageConcat)
}

fun Kotlin_STL(){
    // apply digunakan untuk memperpendek method dari objek tersebut
    val buildString = StringBuilder().apply {
        this.append("Hello ") // bisa gini
        append("Kotlin ") // bisa juga gini
    }
    println(buildString)

    var text = "Hello"
    text.also {
        val message = "$it Kotlin"
        println(message)
    }
    text.let {
        val message = "$it Kotlin"
        println(message)
    }
}

fun Scope_Function_With_Lambda_Receiver(){
    var text = "Hello"
    // run, return blok terakhir
    var result = text.run {
        val from = this
        val to = this.replace("o", "Kotlin")
        "replace text from $from to $to"
    }
    println("result : $result")

    // with, return blok terakhir
    var message1 = "Hello Kotlin!"
    result = with(message1) {
        println("value is $this")
        println("with length ${this.length}")
        "First character is ${this[0]}" + " and last character is ${this[this.length - 1]}"
    }
    println(result)

    // apply digunakan untuk memperpendek method dari objek tersebut
    val buildString = StringBuilder().apply {
        this.append("Hello ") // bisa gini
        append("Kotlin ") // bisa juga gini
    }
    println(buildString)
}

fun Scope_Function_With_Lambda_Argument(){
    // fungsi let, argument "it", argument cannot reassigned
    var message2: String? = null
    message2?.let {
        val length = it.length
        val text = "text length $length"
        println(text)
    } ?: run {
        val text = "message is null"
        println(text)
    }

    // fungsi let, argument "it", argument cannot reassigned
    val text1 = "Hello Kotlin"
    val result1 = text1.also {
        println("value length -> ${it.length}")
    }
    println("text -> $result1")
}

fun Member_Reference(){
    fun count(valueA: Int, valueB
    : Int): Int {
        return valueA + valueB
    }
    val sum: (Int, Int) -> Int = ::count
    println(sum(2,5))

    val numbers = 1.rangeTo(10)
    fun isEvenNumber(number: Int) = number % 2 == 0
    println(numbers.filter(::isEvenNumber))

    fun Int.isEvenNumber() = this % 2 == 0
    println(numbers.filter(Int::isEvenNumber))

    // menggunakan operator "::" untuk membuat global variabel menjadi getter setter object
    println(::globalVar.name)
    println(::globalVar.get())
    ::globalVar.set("Kotlin Academy")
    println(::globalVar.get())
}

fun Function_Inside_Function(){
    // contoh penggunaan function inside function yang ideal
    fun sum(valueA: Int, valueB: Int, valueC: Int): Int {
        fun validateNumber(value: Int) {
            if (value == 0) {
                throw IllegalArgumentException("value must be better than 0")
            }
        }
        fun Int.validateMinusNumber() {
            if (this < 0) {
                throw IllegalArgumentException("value must not below 0")
            }
        }
        validateNumber(valueA)
        validateNumber(valueB)
        validateNumber(valueC)
        // bisa juga menggunakan extension function
        valueA.validateMinusNumber()
        valueB.validateMinusNumber()
        valueC.validateMinusNumber()
        return valueA + valueB + valueC
    }
    println(sum(1, 2, 3))
}

fun Fold_Drop_Take(){
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    val fold = numbers.fold(10) { current, item ->
        println("current $current")
        println("item $item")
        current + item
    }
    println("Fold result: $fold")

    val drop = numbers.drop(3)
    println(drop)

    val drop2 = numbers.dropLast(3)
    println(drop2)

    val take = numbers.take(3)
    println(take)

    val take2 = numbers.takeLast(3)
    println(take2)
}

fun Slice_Distinct_Chuncked(){
    val total = listOf(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
    val index = listOf(2, 3, 5, 8)

    // slice
    var slice = total.slice(3..6)
    println(slice)

    slice = total.slice(3..6 step 2)
    println(slice)

    slice = total.slice(index)
    println(slice)

    // distinct
    val distinct = total.distinct()
    println(distinct)

    val items = listOf(
        Item("1", "Kotlin"),
        Item("2", "is"),
        Item("3", "Awesome"),
        Item("3", "as"),
        Item("3", "Programming"),
        Item("3", "Language")
    )
    val distinctItems = items.distinctBy { it.key }
    distinctItems.forEach {
        println("${it.key} with value ${it.value}")
    }

    val text = listOf("A", "B", "CC", "DD", "EEE", "F", "GGGG")
    val distinctAbjad = text.distinctBy {
        it.length
    }
    println(distinctAbjad)

    // chunked
    val word = "QWERTY"
    val chunked = word.chunked(3)
    println(chunked)

    val chunkedTransform = word.chunked(3) {
        it.toString().toLowerCase()
    }
    println(chunkedTransform)
}

fun Recursion(){
    fun factorial(n: Int): Int {
        return if (n == 1) {
            n
        } else {
            var result = 1
            for (i in 1..n) {
                result *= i
            }
            result
        }
    }

    fun factorialRecursion(n: Int): Int {
        return if (n == 1) {
            n
        } else {
            n * factorialRecursion(n - 1)
        }
    }

    // memory overflow
    println("Factorial 9999 is: ${factorialRecursion(99999)}")

    // solusinya dibawah ini
    tailrec fun factorialTailRecursion(n: Long, result: Long = 1L): Long {
        val newResult = n * result
        return if (n == 1L) {
            newResult
        } else {
            factorialTailRecursion(n - 1L, newResult)
        }
    }
    println("Factorial 99999 is: ${factorialTailRecursion(99999L)}")
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
