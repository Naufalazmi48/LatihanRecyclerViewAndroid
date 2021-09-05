package com.example.submissionandroidpemula.application

import android.content.res.ColorStateList
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.submissionandroidpemula.R
import com.example.submissionandroidpemula.application.viewmodels.DetailProductViewModel
import com.example.submissionandroidpemula.core.domain.model.Product
import com.example.submissionandroidpemula.databinding.ActivityDetailProductBinding
import com.example.submissionandroidpemula.utils.CurrencyConverter
import com.example.submissionandroidpemula.utils.MyPath
import com.example.submissionandroidpemula.utils.MyViewModelFactory
import java.util.*

class DetailProductActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val DETAIL_PRODUCT = "DETAIL_PRODUCT"
        const val EXIST_IN_CART = "EXIST_IN_CART"
    }

    private lateinit var viewModel: DetailProductViewModel
    private lateinit var product: Product
    private lateinit var binding: ActivityDetailProductBinding
    private var isExistInCart: Boolean = false
    private val observer: Observer<Boolean> = Observer { isExist ->
        stateCartButton(isExist)
        if (isExist) Toast.makeText(this, "${product.name} added to cart", Toast.LENGTH_SHORT).show()
        else Toast.makeText(this, "${product.name} deleted from cart", Toast.LENGTH_SHORT).show()
        isExistInCart = isExist
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)

        try {
            product = intent.getParcelableExtra(DETAIL_PRODUCT)
                ?: throw NullPointerException("Product Detail not found")
            isExistInCart = intent.getBooleanExtra(EXIST_IN_CART, false)
            updateUI()
        } catch (e: NullPointerException) {
            Toast.makeText(this, "Maaf terjadi kesalahan", Toast.LENGTH_SHORT).show()
            Log.e(javaClass.name, "${e.message}")
            onBackPressed()
        }
        viewModel = MyViewModelFactory(this).create(DetailProductViewModel::class.java)
        viewModel.productIsExistInCart.observe(this, observer)
        setContentView(binding.root)
    }

    private fun updateUI() {
        with(binding) {
            stateCartButton(isExistInCart)
            Glide.with(applicationContext)
                .load(Uri.parse(MyPath.PRODUCT_ASSETS + product.imgPath))
                .into(productPoster)
            productRating.rating = product.stars
            productName.text = product.name
            productPrice.text = CurrencyConverter.rupiah(product.price)
            productDescription.setText(product.description)
            productSpesification.setText(product.specification)
            addToCart.setOnClickListener(this@DetailProductActivity)
            back.setOnClickListener(this@DetailProductActivity)
        }
    }

    private fun stateCartButton(isExistInCart: Boolean) {
        with(binding) {
            if (isExistInCart) {
                addToCart.backgroundTintList =
                    ColorStateList.valueOf(ContextCompat.getColor(applicationContext, R.color.red))
                addToCart.text = getString(R.string.delete_from_cart)
            } else {
                addToCart.backgroundTintList =
                    ColorStateList.valueOf(
                        ContextCompat.getColor(
                            applicationContext,
                            R.color.teal_700
                        )
                    )
                addToCart.text = getString(R.string.add_to_cart)
            }
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.addToCart -> {
                viewModel.setProductInCart(product, isExistInCart)
            }
            R.id.back -> onBackPressed()
        }
    }
}