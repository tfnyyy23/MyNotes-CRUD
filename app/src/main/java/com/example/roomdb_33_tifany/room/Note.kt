package com.example.roomdb_33_tifany.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val title: String,
    val date: String,
    val note: String
)