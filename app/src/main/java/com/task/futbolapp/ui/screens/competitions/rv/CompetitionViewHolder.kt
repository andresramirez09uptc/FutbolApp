package com.task.futbolapp.ui.screens.competitions.rv

import androidx.recyclerview.widget.RecyclerView
import com.task.futbolapp.R
import com.task.futbolapp.data.api.models.Competition
import com.task.futbolapp.databinding.ActivityCompetitionsBinding
import com.task.futbolapp.utils.loadCircleImage

class CompetitionViewHolder(
    private val binding: ActivityCompetitionsBinding,
    private val onTeamsClickListener: (position: Int) -> Unit,
    ): RecyclerView.ViewHolder(binding.root) {
    fun bind(competition: Competition) {
        with(binding) {
            btnTeams.setOnClickListener {
                onTeamsClickListener(competition.id)
            }

            tvCompetitionName.text = tvCompetitionName.context.getString(
                R.string.competition_name,
                competition.id,
                competition.name
            )

            tvCountryCompetition.text =
                tvCountryCompetition.context.getString(
                    R.string.country_name,
                    competition.area.name
                )

            tvTypeCompetition.text =
                tvTypeCompetition.context.getString(
                    R.string.competition_type,
                    competition.type
                )

            tvPlanCompetition.text =
                tvPlanCompetition.context.getString(
                    R.string.competition_plan,
                    competition.plan
                )


            if(competition.emblem != null){
                ivEmblemCompetition.loadCircleImage(competition.emblem)
            }else{
                ivEmblemCompetition.loadCircleImage(R.drawable.image_emblem_not_found)
            }
        }
    }
}