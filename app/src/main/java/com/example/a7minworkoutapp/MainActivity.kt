package com.example.a7minworkoutapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity()
 {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llBMI.setOnClickListener {
            val intent2 = Intent(this ,BMIactivity ::class.java)
            startActivity(intent2)
        }

        llStart.setOnClickListener {
            val intent = Intent(this , ExerciseActivity :: class.java)
            startActivity(intent)
        }

        llHistory.setOnClickListener {
            val intent = Intent(this , History :: class.java)
            startActivity(intent)

        }
    }
}