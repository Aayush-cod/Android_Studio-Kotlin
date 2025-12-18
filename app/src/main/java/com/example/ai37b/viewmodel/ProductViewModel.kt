package com.example.ai37b.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ai37b.model.ProductModel
import com.example.ai37b.repository.ProductRepo

class ProductViewModel(val prepo : ProductRepo) : ViewModel() {

    fun addProductToDatabase(model : ProductModel, callback : (Boolean, String)-> Unit){
        prepo.addProductToDatabase(model, callback)
    }


    fun editProduct( model : ProductModel, callback: (Boolean, String) -> Unit){
        prepo.editProduct( model, callback)
    }

    fun deleteProduct(productId : String, callback: (Boolean, String) -> Unit){
        prepo.deleteProduct(productId, callback)
    }

//    Initializing getter and setter to fetch products

    private  val _product = MutableLiveData<ProductModel?>()
    val product : MutableLiveData<ProductModel?>
        get() = _product

    private val _allProducts = MutableLiveData<List<ProductModel>?>()
    val allProducts : MutableLiveData<List<ProductModel>?>
        get() = _allProducts

    private val _loading = MutableLiveData<Boolean>()
    val loading : MutableLiveData<Boolean>
        get() = _loading



    fun getProductById(productId: String){

        _loading.postValue(true)
        prepo.getProductById(productId){
            success, message, data ->
            if (success){
                _product.postValue(data)
                _loading.postValue(false)

            }
            _loading.postValue(false)
        }
    }

    fun getAllProduct(){
        _loading.postValue(true)
        prepo.getAllProduct{
            success, message, data ->
            if (success){
                _allProducts.postValue(data)
                _loading.postValue(false)
            }
            _loading.postValue(false)
        }
    }

}