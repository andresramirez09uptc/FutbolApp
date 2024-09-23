package com.task.futbolapp.ui.screens.tems.rv

import androidx.recyclerview.widget.RecyclerView
import com.task.futbolapp.R
import com.task.futbolapp.data.api.models.Team
import com.task.futbolapp.databinding.ActivityTeamsBinding
import com.task.futbolapp.utils.loadCircleImage

class TeamsViewHolder(
    private val binding : ActivityTeamsBinding):
    RecyclerView.ViewHolder(binding.root) {
        fun bind(team: Team) {
            with(binding) {
                tvTeamName.text = team.name

                tvColors.text =
                    tvColors.context.getString(
                        R.string.team_colors,
                        team.clubColors
                    )

                tvVenue.text =
                    tvVenue.context.getString(
                        R.string.team_venue,
                        team.venue
                    )
                if(team.crest != null){
                    ivEmblemCompetition.loadCircleImage(team.crest)
                } else {
                    ivEmblemCompetition.loadCircleImage(R.drawable.image_emblem_not_found)
                }

            }
        }
}