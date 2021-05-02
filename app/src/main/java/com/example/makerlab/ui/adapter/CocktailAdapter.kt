package com.example.makerlab.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.makerlab.ui.model.Coach
import com.example.makerlab.R
import com.example.makerlab.retrofit.CocktailModel
import kotlinx.android.synthetic.main.row_coach.view.*

class CocktailAdapter : RecyclerView.Adapter<CoachViewHolder>(){

    private var listCocktail = mutableListOf<CocktailModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoachViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_coach, parent, false)
        return CoachViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCocktail.size
    }

    override fun onBindViewHolder(holder: CoachViewHolder, position: Int) {
       val cocktail = listCocktail[position]
        holder.name.text = cocktail.name
        holder.description.text = cocktail.receta
    }

    fun setListCoach(coachList: List<CocktailModel>){
        this.listCocktail = coachList.toMutableList()
        notifyDataSetChanged()
    }
}

class CocktailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val name : TextView = itemView.tvName
    val description : TextView = itemView.tvDescription
}