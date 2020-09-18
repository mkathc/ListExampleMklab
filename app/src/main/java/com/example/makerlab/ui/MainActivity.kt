package com.example.makerlab.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.makerlab.R
import com.example.makerlab.room.CoachRepository
import com.example.makerlab.room.CoachRoomDatabase
import com.example.makerlab.ui.mapper.CoachViewMapper
import com.example.makerlab.ui.model.Coach
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(TITLE, "Lista con Room")
            startActivity(intent)
        }
    }


    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext, "On Resume", Toast.LENGTH_SHORT).show()
    }


    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext, "On Pause", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext, "On Destroy", Toast.LENGTH_SHORT).show()

    }
}