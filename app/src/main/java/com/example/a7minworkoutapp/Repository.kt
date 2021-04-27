package com.example.a7minworkoutapp

import androidx.lifecycle.LiveData

class Repository(private val dao: Dao) {
    val allDates:LiveData<List<Dates>> = dao.readAllDates()

    suspend fun  insert(dates: Dates){
        dao.addData(dates)
    }

    suspend fun  deleteAll(){
        dao.deleteAll()
    }
}