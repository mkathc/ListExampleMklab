package com.example.makerlab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.makerlab.ui.model.Coach
import com.example.makerlab.R
import kotlinx.android.synthetic.main.row_coach.view.*

class CoachAdapter : RecyclerView.Adapter<CoachViewHolder>(){

    private var listCoach = mutableListOf<Coach>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoachViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_coach, parent, false)
        return CoachViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCoach.size
    }

    override fun onBindViewHolder(holder: CoachViewHolder, position: Int) {
       val coach = listCoach[position]
        holder.name.text = coach.name
        holder.description.text = coach.description
    }

    fun setListCoach(coachList: List<Coach>){
        this.listCoach = coachList.toMutableList()
        notifyDataSetChanged()
    }
}

class CoachViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val name : TextView = itemView.tvName
    val description : TextView = itemView.tvDescription
}