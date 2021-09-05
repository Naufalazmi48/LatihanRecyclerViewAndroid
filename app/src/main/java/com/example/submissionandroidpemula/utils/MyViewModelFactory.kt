package com.example.submissionandroidpemula.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.submissionandroidpemula.application.viewmodels.DetailProductViewModel
import com.example.submissionandroidpemula.application.viewmodels.MainViewModel
import com.example.submissionandroidpemula.core.domain.usecase.ProductUseCase

class MyViewModelFactory(private val context: Context): ViewModelProvider.Factory {

    companion object {
        @JvmStatic
        private var productUseCase: ProductUseCase? = null
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == MainViewModel::class.java) return MainViewModel(
            productUseCase ?: Injection.getUseCaseInstance(context)
        ) as T

        else if (modelClass == DetailProductViewModel::class.java) return DetailProductViewModel(
            productUseCase ?: Injection.getUseCaseInstance(context)
        ) as T
        return modelClass.newInstance()
    }

}