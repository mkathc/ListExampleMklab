package com.example.makerlab.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.makerlab.ui.model.Coach
import com.example.makerlab.R
import com.example.makerlab.retrofit.CocktailModel
import com.example.makerlab.ui.adapter.CoachAdapter
import com.example.makerlab.ui.adapter.CocktailAdapter
import com.example.makerlab.ui.mapper.CoachViewMapper
import kotlinx.android.synthetic.main.activity_second.*

const val TITLE = "TITULO"

class SecondActivity : AppCompatActivity() {

    private val coachAdapter = CoachAdapter()

    private lateinit var coachViewModel: CoachViewModel

    private val cocktailAdapter = CocktailAdapter()

    private val coachViewMapper = CoachViewMapper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val title = intent.getStringExtra(TITLE)
        textView2.text = title

        coachViewModel = ViewModelProvider(this).get(CoachViewModel::class.java)

        observerCoachList()
        observerCocktailList()
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


    private fun observerCocktailList() {
        coachViewModel.allCocktail.observe(this, Observer { cocktail ->

            if (cocktail.isNotEmpty()) {

                setRecyclerViewCocktail(cocktail)

            } else {

               Toast.makeText(this, "No se pudo descargar la información", Toast.LENGTH_SHORT).show()

            }
        })
        coachViewModel.getCocktail()
    }

    private fun setRecyclerView(list: List<Coach>) {
        rvList.layoutManager = LinearLayoutManager(applicationContext)
        rvList.adapter = coachAdapter
        coachAdapter.setListCoach(list)
    }

    private fun setRecyclerViewCocktail(list: List<CocktailModel>) {
        rvList.layoutManager = LinearLayoutManager(applicationContext)
        rvList.adapter = cocktailAdapter
        cocktailAdapter.setListCoach(list)
    }

    private fun getListCoach(): List<Coach> {
        val list = mutableListOf<Coach>()

        list.add(Coach("",
            "Mary",
            "Mateus",
            "Coach ux"))

        list.add(Coach("",
            "Kath",
            "Caillahua",
            "Coach mobile"))

        list.add(
            Coach(
                "",
                "Carlos",
                "Gomez",
                "Coach videoGames"
            )
        )
        list.add(
            Coach(
                "",
                "Pedro",
                "Gomez",
                "Coach Full stack"
            )
        )
        list.add(
            Coach(
                "",
                "Pablo",
                "Gomez",
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