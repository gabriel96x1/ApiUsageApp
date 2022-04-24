package com.rzs.apiusageapp.data.repository

import com.rzs.apiusageapp.data.data_sorce.NetworkService
import com.rzs.apiusageapp.domain.repository.NetworkRepository
import javax.inject.Inject


class NetworkRepoImpl @Inject constructor(
    private val storeService: NetworkService
    ) : NetworkRepository {

    fun getAllStores() = storeService.searchStores()
    fun getAllProducts() = storeService.searchProducts()



    override fun StoreRepo() {

    }

    override fun ProductRepo() {
        TODO("Not yet implemented")
    }
}