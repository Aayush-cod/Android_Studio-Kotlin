package com.example.ai37b.day1Practice

fun main(){

    //we can add value only after our array is initialize
    var age1 = ArrayList<Int>()
    age1.add(1)
    age1.add(1,20)
    age1.add(5)
//we can add value directly in array while initializing variables.
    var age2 = arrayListOf<Int>(1,20,5)

    var name = arrayListOf<String>("sandis","ram","shyam")
    name.add("hari")
    name.add( 4, "Sita")
    name.remove("shyam")
    name.removeAt( 0)
    println(name)

    var mixArrayList = arrayListOf<Any>("hello",5,2.0)
    println(mixArrayList [0]);
    println(mixArrayList[1]);
    println(mixArrayList [2]);
}