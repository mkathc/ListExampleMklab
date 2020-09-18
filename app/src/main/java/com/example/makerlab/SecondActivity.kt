package com.example.makerlab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(){

    private val coachAdapter = CoachAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val title = intent.getStringExtra("TITULO")
        textView2.text = title

        setRecyclerView()
    }

    fun setRecyclerView(){
        rvList.layoutManager = LinearLayoutManager(applicationContext)
        rvList.adapter = coachAdapter
        coachAdapter.setListCoach(getListCoach())
    }

    fun getListCoach(): List<Coach>{

        val list = mutableListOf<Coach>()
        list.add(Coach("Kath","Coach mobile"))
        list.add(Coach("Carlos","Coach videoGames"))
        list.add(Coach("Pedro","Coach Full stack"))
        list.add(Coach("Pablo","Coach Full stack"))
        list.add(Coach("Jhair","Coach Backend"))

        return list
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}