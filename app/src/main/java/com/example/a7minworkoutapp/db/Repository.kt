package com.example.a7minworkoutapp.db

import androidx.lifecycle.LiveData
import com.example.a7minworkoutapp.models.Dates

class Repository(private val dao: Dao) {
    val allDates:LiveData<List<Dates>> = dao.readAllDates()

    suspend fun  insert(dates: Dates){
        dao.addData(dates)
    }

    suspend fun  deleteAll(){
        dao.deleteAll()
    }
}