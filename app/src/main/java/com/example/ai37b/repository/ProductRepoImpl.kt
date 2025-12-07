package com.example.ai37b.repository

import androidx.compose.ui.util.fastCbrt
import com.example.ai37b.model.ProductModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProductRepoImpl : ProductRepo {

    val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    val ref : DatabaseReference = database.getReference("Products")

    override fun addProductToDatabase(
        model: ProductModel,
        callback: (Boolean, String) -> Unit
    ) {
        val id = ref.push().key.toString()

        ref.child(id).setValue(model)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    callback(true, "Product added Successfully.")

                }else{
                    callback(false, "${it.exception?.message}")
                }
            }
    }

    override fun editProduct(
        userId: String,
        model: ProductModel,
        callback: (Boolean, String) -> Unit
    ) {
        ref.child(userId).updateChildren(model.toMap())
            .addOnCompleteListener {
                if (it.isSuccessful){
                    callback(true, "Product deleted")
                }else{
                    callback(false,"${it.exception?.message}")
                }
            }

    }

    override fun deleteProduct(
        userId: String,
        callback: (Boolean, String) -> Unit
    ) {
        ref.child(userId).removeValue()
            .addOnCompleteListener {
                if (it.isSuccessful){
                    callback(true, "Product deleted")
                }else{
                    callback(false,"${it.exception?.message}")
                }
            }
    }

    override fun getProductById(
        userId: String,
        model: ProductModel,
        callback: (Boolean, String, ProductModel?) -> Unit
    ) {
        ref.child(userId).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
               if (snapshot.exists()){

                   val product = snapshot.getValue(ProductModel::class.java)
                   if (product != null){
                       callback(true, "Product fetched", product)
                   }
               }
            }

            override fun onCancelled(error: DatabaseError) {
                callback(false, "${error.message}", null)
            }
        })
    }

    override fun getAllProduct(
        callback: (Boolean, String, List<ProductModel>) -> Unit)
    {
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){

                    var allProducts = mutableListOf<ProductModel>()

                    for (data in snapshot.children){
                        val product = data.getValue(ProductModel::class.java)
                        if (product != null){
                            allProducts.add(product)
                        }
                    }

                    callback(true, "All product fetched", allProducts)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                callback(false, "${error.message}", emptyList())
            }
        })

    }
}