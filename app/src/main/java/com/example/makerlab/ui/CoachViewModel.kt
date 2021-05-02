package com.example.makerlab.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.makerlab.room.CoachRepository
import com.example.makerlab.room.CoachRoomDatabase
import com.example.makerlab.room.entity.CoachEntity
import com.example.makerlab.ui.mapper.CoachViewMapper
import com.example.makerlab.ui.model.Coach
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoachViewModel (application: Application): AndroidViewModel(application){
    private val repository: CoachRepository
    private val coachViewMapper = CoachViewMapper()

    val allCoaches: LiveData<List<CoachEntity>>

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
}
