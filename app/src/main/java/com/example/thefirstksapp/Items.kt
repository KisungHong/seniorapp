package com.example.thefirstksapp

import com.google.gson.annotations.SerializedName

data class ProductData(
    val img : Int,
    val title : String,
    val price : String
)


data class SearchData(
    val title : String,
    val price : String

)

data class RankingData(
    @SerializedName("pcode") val  pcode : String = "",
    @SerializedName("prank") val  prank : Int ,
    @SerializedName("ptitle") val  ptitle : String = "",
    @SerializedName("pprice") val  pprice : String = "",
    @SerializedName("pimgurl") val  pimgurl : String = "",

)
