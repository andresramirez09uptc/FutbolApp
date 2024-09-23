package com.task.futbolapp.ui.screens.tems.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.futbolapp.data.api.models.Team
import com.task.futbolapp.databinding.ActivityTeamsBinding

class RvTeamsAdapter(): RecyclerView.Adapter<TeamsViewHolder>() {

    var teams: List<Team> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        val binding = ActivityTeamsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return teams.size
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        holder.bind(teams[position])
    }

}