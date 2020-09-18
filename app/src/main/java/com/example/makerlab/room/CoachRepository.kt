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

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class CoachRepository(private val coachDao: CoachDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.

    val allCoaches: LiveData<List<CoachEntity>> = coachDao.getCoaches()

/*    private val job = Job()
    override val coroutineContext: CoroutineContext = Dispatchers.IO + job


    suspend fun getCoaches(): List<CoachEntity> {
        return coroutineScope {
            return@coroutineScope try {
                coachDao.getCoaches().value!!
            } catch (e: Throwable) {
                mutableListOf<CoachEntity>()
            }
        }
    }*/

    suspend fun insert(coachEntity: CoachEntity) {
        try {
            coachDao.insert(coachEntity)
        } catch (e: Throwable) {
            Log.e("Debug", "no guarda")
        }
    }
}