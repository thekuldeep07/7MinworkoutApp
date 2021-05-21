package com.example.a7minworkoutapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dates_table")
data class Dates(
        @PrimaryKey(autoGenerate = true)
        val id : Int,
        val description:String)