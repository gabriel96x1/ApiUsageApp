package com.rzs.apiusageapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rzs.apiusageapp.data.repository.NetworkRepoImpl
import com.rzs.apiusageapp.domain.model.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class StoresViewModel @Inject constructor(
    private val repository: NetworkRepoImpl
) : ViewModel() {
    val storeList = MutableLiveData<List<Store>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllStores(){
        val response = repository.getAllStores()
        response.enqueue(object : Callback<List<Store>> {
            override fun onResponse(call: Call<List<Store>>, response: Response<List<Store>>) {
                storeList.postValue(response.body())
            }
            override fun onFailure(call: Call<List<Store>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}