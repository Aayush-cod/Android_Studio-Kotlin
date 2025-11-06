package com.example.ai37b.day1Practice

fun main() {
    displayList()
    typesList()
}

    fun displayList() {
        val numbers: List<String> = listOf("one", "two", "three", "four")

        println("Number of elements : ${numbers.size}")
        println("Third element: ${numbers.get(2)}")
        println("Fourth element: ${numbers[3]}")
        println("Index of element \"two\" ${numbers.indexOf("two")}")
    }

// Immmutable and mutable list
fun typesList(){
//    Immutable list
     val lst = listOf("one", "two", "three")
    println("ImMutable list")
    for (i in lst.indices){
        println(lst[i])
    }

    println()
//    Mutable list
    val mutableLst = mutableListOf("one", "two", "three")
    mutableLst.add("Four")
    println("mutable list")
    for ( i in mutableLst.indices){
        println(mutableLst[i])
    }



}
