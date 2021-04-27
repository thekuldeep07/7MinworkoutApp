package com.example.a7minworkoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_b_m_iactivity.*
import kotlinx.android.synthetic.main.activity_finish.*
import kotlinx.android.synthetic.main.activity_history.*

class History : AppCompatActivity() {
    lateinit var  viewModel :ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        rvHistory.layoutManager = LinearLayoutManager(this)
        val adapter = AdapterDates(this)
        rvHistory.adapter =adapter


        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
                ViewModel::class.java
        )

        clearBtn.setOnClickListener {
            viewModel.deleteAll()
        }

        viewModel.readAllDates.observe(this,{ list ->

            if (list.size == 0){
                Log.d("check","Items")
            }
            list?.let {
                adapter.updateList(it)
            }

        })

        setSupportActionBar(toolbar_history_activity)

        val actionbar = supportActionBar //actionbar
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true) //set back button
            actionbar.title = "HISTORY" // Setting an title in the action bar.
        }

        toolbar_history_activity.setNavigationOnClickListener {
            finish()
        }
    }
}