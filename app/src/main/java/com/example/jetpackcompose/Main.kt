package com.example.jetpackcompose

import java.util.*

fun main() {
//    printHello()
//
//    val i: Int = 6
//    val b1 = i.toByte()
//    println(b1)
//
//    val numberOfFish = 50
//    val numberOfPlants = 23
//    if (numberOfFish > numberOfPlants) {
//        println("Good ratio!")
//    } else {
//        println("Unhealthy ratio")
//    }
//
//    val fish = 50
//    if (fish in 1..100) { //  thuộc trong khoảng này không
//        println(fish)
//    }
//    if (numberOfFish == 0) {
//        println("Empty tank")
//    } else if (numberOfFish < 40) {
//        println("Got fish!")
//    } else {
//        println("That's a lot of fish!")
//    }
//
//    when (numberOfFish) {
//        0  -> println("Empty tank")
//        in 1..39 -> println("Got fish!")
//        else -> println("That's a lot of fish!")
//    }

//    var rocks: Int? = null
//    var fishFoodTreats = 6
////    if (fishFoodTreats != null) {
////        fishFoodTreats = fishFoodTreats.dec() //  dec là hàm giảm xuống 1 đơn vị
////    }
//    rocks = rocks?.dec() ?: 0 // đấu hỏi chấm đại diện là nó khác null
//
//    val s : String = "lsdkfjlsdfjlksdjflsdjf"
//    val len = s!!.length
//
//    println(len)


//    val school = listOf("mackerel", "trout", "halibut") //  danh sách không thể thay đổi
//    println(school)

//    val myList = mutableListOf("tuna", "salmon", "shark") // dánh sách có thể thay đổi đcược
//    myList.remove("shark")
//    println(myList)
//
//    val school = arrayOf("shark", "salmon", "minnow")
//    for (element in school) {
//        print(element + " \n")
//    }
//
//    for ((index, element) in school.withIndex()) { // get index biến đấu là index 2 là đối tơngj
//        println("Item at $index is $element\n")
//    }
//
//    for (i in 1..5) print(i) //  lấy từ 1 đến 5
//
//    for (i in 5 downTo 1) print(i) /*lấy từ 5 đến 1*/
//
//    for (i in 3..6 step 2) print(i)  // lấy từ 3 đến 6 những là nhảy 2 bước
//
//    for (i in 'd'..'g') print (i)  // lấy chữ
//
//    repeat(2) {
//        println("A fish is swimming")
//    } // hàm rêpat lặp 2 lần
//
//
//    val temperature = 10
//    val isHot = if (temperature > 50) true else false // check luôn if trên biến như toán tử
//    println(isHot)
//
//    val message = "The water temperature is ${ if (temperature > 50) "too warm" else "OK" }." // check trong string
//    println(message)

//    feedTheFish()
//    swim()   // uses default speed
//    swim("slow")   // positional argument
//    swim(speed="turtle-like")   // named parameter
//
//    val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
//
//    println(decorations.filter { it[0] == 'p' }) //  lọc list có chữ p
//
//    val filtered = decorations.asSequence().filter { it[0] == 'p' }
//    println("filtered: $filtered")

// hàm gọn có tham số truyền vào rút gon
//
//    var dirtyLevel = 20
//    val waterFilter = { dirty : Int -> dirty / 2}
//    println(waterFilter(dirtyLevel))

    // hàm gọi trong hàm

    fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
        return operation(dirty)
    }

    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
    fun increaseDirty(start: Int) = start + 1
    println(updateDirty(30, waterFilter))
    println(updateDirty(30, ::increaseDirty)) // :: khí hiệu nó là hàm


    var dirtyLevel = 19;
    dirtyLevel = updateDirty(dirtyLevel) { dirtyLevel -> dirtyLevel + 23 }
    println(dirtyLevel)

    // cách dùng enum
// giống singletons
    println(Color.RED)
    println(Color.BLUE)
    println(Color.GREEN)
}

fun feedTheFish() {
    val day = randomDay()
    val food = "pellets"
    println("Today is $day and the fish eat $food")
}

fun randomDay(): String {
    val week = arrayOf(
        "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    )
    return week[Random().nextInt(week.size)]
}

fun printHello() {
    println("Hello World")
}

fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

fun swim(speed: String = "fast") {
    println("swimming $speed")
}

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        temperature > 30 -> true
        dirty > 30 -> true
        day == "Sunday" -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"


enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
}
