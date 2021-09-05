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
import com.example.submissionandroidpemula.databinding.FragmentHomeBinding
import com.example.submissionandroidpemula.utils.MyViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private var productAdapter: ProductAdapter = ProductAdapter()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val observer: Observer<List<Product>> = Observer {
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
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupAdapter()
        viewModel = MyViewModelFactory(requireContext()).create(MainViewModel::class.java)
        viewModel.listProducts.observe(viewLifecycleOwner, observer)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllProducts()
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