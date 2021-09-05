package com.example.submissionandroidpemula.core.source.local

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import com.example.submissionandroidpemula.core.domain.model.Product

class SharedPreference(private val context: Context) : Databases, ISharedPreference {
    private val CART_PREFERENCES = "CART_PREFERENCES"
    private val SPLASHSCREEN = "SPLASHSCREEN"
    private val KEY_SPLASHSCREEN = "KEY_SPLASHSCREEN"

    private var cartInstance: SharedPreferences? = null
    private var splashScreenInstance: SharedPreferences? = null

    private fun getInstance(name: String): SharedPreferences? {
        return when (name) {
            CART_PREFERENCES -> {
                cartInstance ?: synchronized(this) {
                    cartInstance ?: context.getSharedPreferences(name, Context.MODE_PRIVATE)
                }
            }
            SPLASHSCREEN -> {
                splashScreenInstance ?: synchronized(this) {
                    splashScreenInstance ?: context.getSharedPreferences(name, Context.MODE_PRIVATE)
                }
            }
            else -> null
        }
    }

    override fun getProductInCart(productId: String): String? {
        return try {
            return getInstance(CART_PREFERENCES)?.getString(productId, null)
        } catch (e: NullPointerException) {
            Log.e(javaClass.name, "Error in sharedpreference instance")
            null
        }
    }

    override fun addProductToCart(product: Product) {
        try {
            getInstance(CART_PREFERENCES)?.edit {
                putString(product.id, product.id)
                apply()
            }
        } catch (e: NullPointerException) {
            Log.e(javaClass.name, "Error in sharedpreference instance")
        }
    }

    override fun deleteProductFromCart(product: Product) {
        try {
            getInstance(CART_PREFERENCES)?.edit {
                remove(product.id)
                apply()
            }
        } catch (e: NullPointerException) {
            Log.e(javaClass.name, "Error in sharedpreference instance")
        }
    }

    override fun getStatusVisibilitySplashScreen(): Boolean {
        return try {
            getInstance(SPLASHSCREEN)?.getBoolean(KEY_SPLASHSCREEN, true) ?: true
        } catch (e: NullPointerException) {
            Log.e(javaClass.name, "Error in sharedpreference instance")
            false
        }
    }

    override fun setStatusVisibilitySplashScreen(visibility: Boolean) {
        try {
            getInstance(SPLASHSCREEN)?.edit {
                putBoolean(KEY_SPLASHSCREEN, visibility)
                apply()
            }
        } catch (e: NullPointerException) {
            Log.e(javaClass.name, "Error in sharedpreference instance")
        }
    }
}