package com.example.makerlab.retrofit

import com.google.gson.annotations.SerializedName

data class CocktailModel(
    @SerializedName("idDrink")
    var id : Int,
    @SerializedName("strDrink")
    var name : String,
    @SerializedName("strInstructions")
    var receta: String
)