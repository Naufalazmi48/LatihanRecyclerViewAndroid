package com.example.submissionandroidpemula.application.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionandroidpemula.adapter.ProductAdapter
import com.example.submissionandroidpemula.application.DetailProductActivity
import com.example.submissionandroidpemula.application.viewmodels.MainViewModel
import com.example.submissionandroidpemula.core.domain.model.Product
import com.example.submissionandroidpemula.databinding.FragmentCartBinding
import com.example.submissionandroidpemula.utils.MyViewModelFactory

class CartFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private var productAdapter: ProductAdapter = ProductAdapter()
    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    private val observer: Observer<List<Product>> = Observer {
        if (it.isNullOrEmpty()) {
            binding.emptyCart.visibility = View.VISIBLE
        } else binding.emptyCart.visibility = View.GONE

        productAdapter.setProducts(it)
    }
    private val adapterOnProductClicked = { product: Product ->
        val intent = Intent(requireContext(), DetailProductActivity::class.java)
        val isExistInCart = viewModel.productIsExitsInCart(product)
        intent.putExtra(DetailProductActivity.DETAIL_PRODUCT, product)
        intent.putExtra(DetailProductActivity.EXIST_IN_CART, isExistInCart)
        startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)

        setupAdapter()
        viewModel = MyViewModelFactory(requireContext()).create(MainViewModel::class.java)
        viewModel.listProductsInCart.observe(viewLifecycleOwner, observer)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllProductsInCart()
    }

    private fun setupAdapter() {
        with(binding) {
            productAdapter.onItemClick = adapterOnProductClicked
            rvProducts.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            rvProducts.adapter = productAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}