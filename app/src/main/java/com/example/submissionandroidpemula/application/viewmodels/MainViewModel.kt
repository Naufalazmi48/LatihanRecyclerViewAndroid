package com.example.submissionandroidpemula.application.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.submissionandroidpemula.core.domain.model.Product
import com.example.submissionandroidpemula.core.domain.usecase.ProductUseCase

class MainViewModel(private val useCase: ProductUseCase) : ViewModel() {
    private val _listProducts = MutableLiveData<List<Product>>()
    val listProducts: LiveData<List<Product>> = _listProducts

    private val _listProductsInCart = MutableLiveData<List<Product>>()
    val listProductsInCart: LiveData<List<Product>> = _listProductsInCart

    fun getAllProducts() {
        _listProducts.postValue(useCase.getAllProducts())
    }

    fun getAllProductsInCart() {
        _listProductsInCart.postValue(useCase.getAllProductsInCart())
    }

    fun productIsExitsInCart(product: Product) = useCase.productIsExistInCart(product)
}