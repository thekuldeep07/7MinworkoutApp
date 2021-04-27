package com.example.a7minworkoutapp

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Dates::class],version = 1 ,exportSchema = false)
abstract class Database:RoomDatabase() {

    abstract fun dao():Dao

    companion object {
        @Volatile
        private var INSTANCE : com.example.a7minworkoutapp.Database?=null

        fun getDatabase(context: Context):com.example.a7minworkoutapp.Database{
            val instance = INSTANCE
            if(instance!=null){
                return instance
            }

            synchronized(this){
                val instance = androidx.room.Room.databaseBuilder(
                        context.applicationContext,com.example.a7minworkoutapp.Database::class.java,
                        "dates_table"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}