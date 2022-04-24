package com.rzs.apiusageapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rzs.apiusageapp.data.repository.NetworkRepoImpl
import com.rzs.apiusageapp.domain.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel  @Inject constructor(
    private val repository: NetworkRepoImpl
) : ViewModel() {
    val productList = MutableLiveData<List<Product>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllProducts(){
        val response = repository.getAllProducts()
        response.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                productList.postValue(response.body())
            }
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}