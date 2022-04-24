package com.rzs.apiusageapp.data.data_sorce

import com.rzs.apiusageapp.domain.model.Product
import com.rzs.apiusageapp.domain.model.Store
import retrofit2.Call
import retrofit2.http.GET

interface NetworkService {
    @GET("establishments")
    fun searchStores(
    ): Call<List<Store>>

    @GET("products")
    fun searchProducts(
    ): Call<List<Product>>

}