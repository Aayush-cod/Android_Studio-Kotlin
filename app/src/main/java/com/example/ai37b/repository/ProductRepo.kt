package com.example.ai37b.repository

import com.example.ai37b.model.ProductModel
import javax.security.auth.callback.Callback

interface ProductRepo {

    fun addProductToDatabase(model : ProductModel, callback : (Boolean, String)-> Unit)

    fun editProduct(userId : String, model : ProductModel, callback: (Boolean, String) -> Unit)

    fun deleteProduct(userId : String, callback: (Boolean, String) -> Unit)

    fun getProductById(userId: String, model: ProductModel, callback: (Boolean, String, ProductModel?) -> Unit)

    fun getAllProduct(callback: (Boolean, String, List<ProductModel>) -> Unit)
}