package com.example.makerlab.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coach")
data class CoachEntity(
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    val name: String,
    val apellido: String,
    val description: String
)