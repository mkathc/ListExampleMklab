package com.example.makerlab.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.makerlab.ui.model.Coach
import com.example.makerlab.R
import com.example.makerlab.adapter.CoachAdapter
import com.example.makerlab.room.CoachRepository
import com.example.makerlab.room.CoachRoomDatabase
import com.example.makerlab.room.entity.CoachEntity
import com.example.makerlab.ui.mapper.CoachViewMapper
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.coroutines.coroutineScope

const val TITLE = "TITULO"

class SecondActivity : AppCompatActivity() {

    private val coachAdapter = CoachAdapter()
    private lateinit var coachViewModel: CoachViewModel
    private val coachViewMapper = CoachViewMapper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val title = intent.getStringExtra(TITLE)
        textView2.text = title
        coachViewModel = ViewModelProvider(this).get(CoachViewModel::class.java)
        observerCoachList()
    }

    private fun observerCoachList() {
        coachViewModel.allCoaches.observe(this, Observer { coach ->

            if (coach.isNotEmpty()) {

                val newList = mutableListOf<Coach>()

                coach.forEach {
                    newList.add(coachViewMapper.mapToView(it))
                }

                setRecyclerView(newList)

            } else {

                getListCoach().forEach {
                    coachViewModel.insert(it)
                }

            }
        })
    }

    private fun setRecyclerView(list: List<Coach>) {
        rvList.layoutManager = LinearLayoutManager(applicationContext)
        rvList.adapter = coachAdapter
        coachAdapter.setListCoach(list)
    }

    private fun getListCoach(): List<Coach> {
        val list = mutableListOf<Coach>()
        list.add(Coach("Kath", "Coach mobile"))
        list.add(
            Coach(
                "Carlos",
                "Coach videoGames"
            )
        )
        list.add(
            Coach(
                "Pedro",
                "Coach Full stack"
            )
        )
        list.add(
            Coach(
                "Pablo",
                "Coach Full stack"
            )
        )
        return list
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}