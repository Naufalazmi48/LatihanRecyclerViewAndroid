package com.example.submissionandroidpemula.utils

import android.content.Context
import com.example.submissionandroidpemula.application.fragments.AboutFragment
import com.example.submissionandroidpemula.core.domain.IProductRepository
import com.example.submissionandroidpemula.core.domain.usecase.ProductUseCase
import com.example.submissionandroidpemula.core.repository.ProductRepository
import com.example.submissionandroidpemula.core.source.local.Databases
import com.example.submissionandroidpemula.core.source.local.SharedPreference

object Injection {
    private val instanceRepository: IProductRepository? = null
    private val instanceDatabases: Databases? = null
    private val useCaseProduct: ProductUseCase? = null

    fun getUseCaseInstance(context: Context): ProductUseCase {
        return useCaseProduct ?: synchronized(this) {
            useCaseProduct ?: ProductUseCase(
                repository = instanceRepository ?: getRepositoryInstance(
                    databases = instanceDatabases ?: getDatabaseInstance(
                        context = context
                    )
                )
            )
        }
    }

    fun getRepositoryInstance(databases: Databases): IProductRepository =
        instanceRepository ?: synchronized(this) {
            instanceRepository ?: ProductRepository(databases)
        }

    private fun getDatabaseInstance(context: Context): Databases =
        instanceDatabases ?: synchronized(this) {
            instanceDatabases ?: SharedPreference(context)
        }
}