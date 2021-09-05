package com.example.submissionandroidpemula.core.domain.usecase

import android.util.Log
import com.example.submissionandroidpemula.core.domain.IProductRepository
import com.example.submissionandroidpemula.core.domain.model.Product

class ProductUseCase(private val repository: IProductRepository) {
    fun addProductToCart(product: Product): Boolean {
        return try {
            repository.productIsAvailableInCart(product.id) ?: throw NullPointerException()

            Log.e(javaClass.name, "Product is exist in cart")
            false
        } catch (e: NullPointerException) {
            repository.addProductToCart(product)
            true
        }
    }

    fun getAllProducts(): List<Product> = repository.getAllProducts()

    fun getAllProductsInCart(): List<Product> =
        repository.getAllProducts().filter { product ->
            repository.productIsAvailableInCart(product.id) != null
        }

    fun deleteProductFromCart(product: Product): Boolean {
        return try {
            repository.productIsAvailableInCart(product.id) ?: throw NullPointerException()
            repository.deleteProductFromCart(product)
            true
        } catch (e: NullPointerException) {
            Log.e(javaClass.name, "Product is not exist in cart")
            false
        }
    }

    fun productIsExistInCart(product: Product): Boolean =
        repository.productIsAvailableInCart(product.id) != null
}