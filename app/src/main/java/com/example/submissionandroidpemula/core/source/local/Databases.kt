package com.example.submissionandroidpemula.core.source.local

import com.example.submissionandroidpemula.core.domain.model.Product

interface Databases {
    fun getProductInCart(productId: String):String?
    fun addProductToCart(product: Product)
    fun deleteProductFromCart(product: Product)
}