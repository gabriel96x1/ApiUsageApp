package com.rzs.apiusageapp.presentation.fragments

import android.app.SearchManager
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rzs.apiusageapp.R
import com.rzs.apiusageapp.databinding.ProductItemBinding
import com.rzs.apiusageapp.databinding.ProductsFragmentBinding
import com.rzs.apiusageapp.databinding.StoresFragmentBinding
import com.rzs.apiusageapp.domain.model.Product
import com.rzs.apiusageapp.domain.model.Store
import com.rzs.apiusageapp.presentation.adapters.ProductAdapter
import com.rzs.apiusageapp.presentation.adapters.StoreAdapter
import com.rzs.apiusageapp.presentation.viewmodel.ProductsViewModel
import com.rzs.apiusageapp.presentation.viewmodel.StoresViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : Fragment() {

    companion object {
        fun newInstance() = ProductsFragment()
    }

    private lateinit var viewModel: ProductsViewModel
    private lateinit var binding : ProductsFragmentBinding
    private lateinit var rView : RecyclerView
    private var products : List<Product> = ArrayList()
    private lateinit var adapter : ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProductsFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[ProductsViewModel::class.java]

        viewModel.getAllProducts()

        viewModel.productList.observe(viewLifecycleOwner, Observer {
            products = it
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("Products", products.toString())
        rView = binding.recycler
        adapter = ProductAdapter(products, products.size)
        rView.layoutManager = LinearLayoutManager(context)
        rView.adapter = adapter


    }

}