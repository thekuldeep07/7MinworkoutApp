package com.example.a7minworkoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_finish.*
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat
import java.util.*

class FinishActivity : AppCompatActivity() {

    lateinit var  viewModel :ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        setSupportActionBar(toolobar_finish_activity)
        val actionbar = supportActionBar
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true)
        }

        toolobar_finish_activity.setNavigationOnClickListener {
            onBackPressed()
        }

        btnFinish.setOnClickListener {
            finish()
        }


       addDateToDatabase()

//

    }

    private fun addDateToDatabase() {
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
                ViewModel::class.java
        )

        val c = Calendar.getInstance()
        val dateTime = c.time

        val sdf = SimpleDateFormat("dd MMM yyyy HH:mm:ss",Locale.getDefault())
        val date = sdf.format(dateTime)


        viewModel.addDate(Dates(0, date))




    }
}