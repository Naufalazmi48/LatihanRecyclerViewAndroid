package com.example.submissionandroidpemula.application.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.submissionandroidpemula.core.domain.model.Product
import com.example.submissionandroidpemula.core.domain.usecase.ProductUseCase

class DetailProductViewModel(private val useCase: ProductUseCase): ViewModel() {
    private val _productIsExistInCart = MutableLiveData<Boolean>()
    val productIsExistInCart: LiveData<Boolean> = _productIsExistInCart

    fun setProductInCart(product: Product, isExist: Boolean) {
        if (!isExist) {
            useCase.addProductToCart(product)

            _productIsExistInCart.postValue(true)
        } else {
            useCase.deleteProductFromCart(product)
            _productIsExistInCart.postValue(false)
        }
    }
}