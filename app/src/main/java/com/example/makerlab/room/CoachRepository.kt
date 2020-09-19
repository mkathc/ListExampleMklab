package com.example.makerlab.room

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.makerlab.room.dao.CoachDao
import com.example.makerlab.room.entity.CoachEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.CoroutineContext

class CoachRepository(private val coachDao: CoachDao) {

    val allCoaches: LiveData<List<CoachEntity>> = coachDao.getCoaches()

    suspend fun insert(coachEntity: CoachEntity) {
        try {
            coachDao.insert(coachEntity)
        } catch (e: Throwable) {
            Log.e("Debug", "no guarda")
        }
    }
}