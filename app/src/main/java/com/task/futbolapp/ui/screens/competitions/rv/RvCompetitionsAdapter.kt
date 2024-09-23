package com.task.futbolapp.ui.screens.competitions.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.futbolapp.data.api.models.Competition
import com.task.futbolapp.databinding.ActivityCompetitionsBinding

class RvCompetitionsAdapter(
    private val onViewInfoClickListener: (id: Int) -> Unit
): RecyclerView.Adapter<CompetitionViewHolder>() {

    var competitions = emptyList<Competition>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetitionViewHolder {
        val binding =  ActivityCompetitionsBinding .inflate(LayoutInflater.from(parent.context), parent, false)
        return CompetitionViewHolder(
            binding = binding,
            onTeamsClickListener = onViewInfoClickListener)
    }

    override fun getItemCount(): Int = competitions.size

    override fun onBindViewHolder(holder: CompetitionViewHolder, position: Int) {
        holder.bind(competitions[position])
    }

}