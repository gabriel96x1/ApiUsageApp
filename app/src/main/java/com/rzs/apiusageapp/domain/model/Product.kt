package com.rzs.apiusageapp.domain.model

import com.google.gson.annotations.SerializedName

data class Product (

    @SerializedName("id")
    val productId : Int,

    @SerializedName("name")
    val name : String,

    @SerializedName("description")
    val description : String,

    @SerializedName("price")
    val price : Int,
)