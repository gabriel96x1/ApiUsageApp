package com.rzs.apiusageapp.domain.repository

import com.rzs.apiusageapp.domain.model.Product
import com.rzs.apiusageapp.domain.model.Store

interface NetworkRepository {
    fun StoreRepo()
    fun ProductRepo()
}