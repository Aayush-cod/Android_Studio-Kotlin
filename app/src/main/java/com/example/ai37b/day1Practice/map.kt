package com.example.ai37b.day1Practice

fun main(){
    map()
    immutableMap()
    mutableMap()
}

fun map(){
    val countriesCapitals = mapOf(
        "Nepal" to "Kathmandu",
        "China" to "Beijing",
        "India" to "New Delhi"
    )
    println("All keys: ${countriesCapitals.keys}")
    println("All values: ${countriesCapitals.values}")
    println("Capital of Nepal is: ${countriesCapitals ["Nepal"]}")
}

fun immutableMap(){

    val studentMarks = mapOf(
        "ram" to 45,
        "shyam" to 45,
        "hari" to 45,
        "gita" to 45,
    )

    println("Enter student name : ")
    val input : String = readln().lowercase()
    println(studentMarks[input])
}

fun mutableMap(){

    val studentMarks = mutableMapOf(
        "ram" to 45,
        "shyam" to 45,
        "hari" to 45,
        "gita" to 45,
    )

    studentMarks["ram"] = 60
    studentMarks.put("sabin", 80)
    println("Enter student name:")
    val input : String = readln().lowercase()
    println(studentMarks[input])

}
