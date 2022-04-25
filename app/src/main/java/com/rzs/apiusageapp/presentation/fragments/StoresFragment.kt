package com.rzs.apiusageapp.presentation.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rzs.apiusageapp.R
import com.rzs.apiusageapp.databinding.StoresFragmentBinding
import com.rzs.apiusageapp.domain.model.Store
import com.rzs.apiusageapp.presentation.adapters.StoreAdapter
import com.rzs.apiusageapp.presentation.viewmodel.StoresViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoresFragment : Fragment() {

    companion object {
        fun newInstance() = StoresFragment()
    }

    private lateinit var viewModel: StoresViewModel
    private lateinit var binding : StoresFragmentBinding
    private lateinit var rView : RecyclerView
    private var stores : List<Store> = ArrayList()
    private lateinit var adapter : StoreAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = StoresFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[StoresViewModel::class.java]
        viewModel.getAllStores()

        viewModel.storeList.observe(viewLifecycleOwner, Observer {
            stores = it
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Log.d("Stores", stores.toString())
        rView = binding.recycler
        adapter = StoreAdapter(stores, stores.size)
        rView.layoutManager = LinearLayoutManager(context)
        rView.adapter = adapter
    }

}