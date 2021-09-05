package com.example.submissionandroidpemula.core.repository

import com.example.submissionandroidpemula.core.domain.IProductRepository
import com.example.submissionandroidpemula.core.domain.model.Product
import com.example.submissionandroidpemula.core.source.ProductDummy
import com.example.submissionandroidpemula.core.source.local.Databases

class ProductRepository(private val databases: Databases): IProductRepository {
    override fun addProductToCart(product: Product) { databases.addProductToCart(product) }

    override fun getAllProducts(): List<Product> = ProductDummy.getAllProducts()

    override fun deleteProductFromCart(product: Product) { databases.deleteProductFromCart(product)}
    override fun productIsAvailableInCart(productId: String): String? = databases.getProductInCart(productId)
}