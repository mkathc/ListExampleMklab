package com.example.makerlab.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CocktailInterface {
    @GET("1/search.php?s=margarita")
    fun getList(): Call<List<CocktailModel>>
}