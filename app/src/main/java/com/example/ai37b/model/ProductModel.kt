package com.example.ai37b.model

data class ProductModel(
    var productId : String = "",
    var productName : String = "",
    var dom : String = "",
    var imageUrl : String = ""
){
    fun toMap(): Map<String, Any?>{

        return mapOf(
            "productId" to productId,
            "productName" to productName,
            "dom" to dom,
            "imageUrl" to imageUrl

        )
    }
}
