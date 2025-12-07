package com.example.ai37b.model

data class ProductModel(
    val productId : String,
    val productName : String,
    val dom : String = "",
){
    fun toMap(): Map<String, Any?>{

        return mapOf(
            "productId" to productId,
            "productName" to productName,
            "dom" to dom,

        )
    }
}
