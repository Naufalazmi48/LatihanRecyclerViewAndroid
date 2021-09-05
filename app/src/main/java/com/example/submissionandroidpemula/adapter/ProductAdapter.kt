package com.example.submissionandroidpemula.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionandroidpemula.R
import com.example.submissionandroidpemula.core.domain.model.Product
import com.example.submissionandroidpemula.databinding.ProductItemBinding
import com.example.submissionandroidpemula.utils.CurrencyConverter
import com.example.submissionandroidpemula.utils.MyPath

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var listProducts: List<Product> = arrayListOf()
    var onItemClick: ((Product) -> Unit)? = null

    fun setProducts(newList: List<Product>) {
        listProducts = newList
        notifyDataSetChanged()
    }

    inner class ProductViewHolder(itemView: View, private val context: Context) :
        RecyclerView.ViewHolder(itemView) {
        private val binding = ProductItemBinding.bind(itemView)
        fun bind(product: Product) {
            with(binding) {
                Glide.with(context)
                    .load(Uri.parse(MyPath.PRODUCT_ASSETS + product.imgPath))
                    .into(poster)
                price.text = CurrencyConverter.rupiah(product.price)
                ratingBar.rating = product.stars
                productName.text = product.name
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listProducts[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false),
            parent.context
        )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(listProducts[position])
    }

    override fun getItemCount(): Int = listProducts.size
}