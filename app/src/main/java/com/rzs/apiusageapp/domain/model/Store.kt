package com.rzs.apiusageapp.domain.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Store(

    @SerializedName("id")
    val storeId : Int,

    @SerializedName("name")
    val name : String,

    @SerializedName("image")
    val image : String,

    @SerializedName("address")
    val address : String,
)