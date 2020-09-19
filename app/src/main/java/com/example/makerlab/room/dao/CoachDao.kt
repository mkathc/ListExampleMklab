package com.example.makerlab.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.makerlab.room.entity.CoachEntity

@Dao
interface CoachDao {
    @Query("SELECT * from coach")
    fun getCoaches(): LiveData<List<CoachEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(coachEntity: CoachEntity)

    @Query("DELETE FROM coach")
    suspend fun deleteAll()
}