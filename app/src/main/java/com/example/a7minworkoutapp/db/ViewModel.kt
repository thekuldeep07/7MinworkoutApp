package com.example.a7minworkoutapp.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.a7minworkoutapp.models.Dates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application):AndroidViewModel(application)
{
  private val repository : Repository

  val readAllDates : LiveData<List<Dates>>

  init{
      val dao = Database.getDatabase(application).dao()
      repository= Repository(dao)
      readAllDates = repository.allDates
  }

  fun deleteAll(){
      viewModelScope.launch(Dispatchers.IO) {
          repository.deleteAll()
      }
  }

  fun addDate(date: Dates) {
      viewModelScope.launch (Dispatchers.IO){
          repository.insert(date)
      }
  }

}