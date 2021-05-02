package com.example.makerlab.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.makerlab.retrofit.CocktailInterface
import com.example.makerlab.retrofit.CocktailModel
import com.example.makerlab.room.CoachRepository
import com.example.makerlab.room.CoachRoomDatabase
import com.example.makerlab.room.entity.CoachEntity
import com.example.makerlab.ui.mapper.CoachViewMapper
import com.example.makerlab.ui.model.Coach
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoachViewModel (application: Application): AndroidViewModel(application){
    private val repository: CoachRepository
    private val coachViewMapper = CoachViewMapper()

    val allCoaches: LiveData<List<CoachEntity>>

    val _allCocktail = MutableLiveData<List<CocktailModel>>()
    val allCocktail: LiveData<List<CocktailModel>> = _allCocktail

    init {
        val coachDao = CoachRoomDatabase.getDatabase(application).coachDao()
        repository = CoachRepository(coachDao)
        allCoaches = repository.allCoaches
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(coach: Coach) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(coachViewMapper.mapToUseCase(coach))
    }

    fun getCocktail(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CocktailInterface::class.java)
        val call = service.getList()

        call.enqueue(object : Callback<List<CocktailModel>> {
            override fun onResponse(call: Call<List<CocktailModel>>, response: Response<List<CocktailModel>>) {
                if (response.code() == 200) {
                    _allCocktail.value = response.body()
                }

                /*else{
                   // response.code() == 400
                   // response.code() == 500
                }*/
            }
            override fun onFailure(call: Call<List<CocktailModel>>, t: Throwable) {

            }
        })
    }
}
