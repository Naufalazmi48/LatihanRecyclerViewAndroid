package com.example.submissionandroidpemula.core.domain

import com.example.submissionandroidpemula.core.domain.model.Product

interface IProductRepository {
    fun addProductToCart(product: Product)
    fun getAllProducts(): List<Product>
    fun deleteProductFromCart(product: Product)
    fun productIsAvailableInCart(productId: String): String?
}