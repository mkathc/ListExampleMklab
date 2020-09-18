package com.example.makerlab.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.makerlab.room.dao.CoachDao
import com.example.makerlab.room.entity.CoachEntity
import com.example.makerlab.ui.model.Coach

@Database(entities = arrayOf(CoachEntity::class), version = 1, exportSchema = false)
public abstract class CoachRoomDatabase : RoomDatabase() {

    abstract fun coachDao(): CoachDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: CoachRoomDatabase? = null

        fun getDatabase(context: Context): CoachRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CoachRoomDatabase::class.java,
                    "coach_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}