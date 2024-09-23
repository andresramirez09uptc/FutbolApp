package com.task.futbolapp.ui.screens.tems

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.futbolapp.R
import com.task.futbolapp.data.viewmodel.TeamsViewModel
import com.task.futbolapp.databinding.ActivityViewTeamsBinding
import com.task.futbolapp.ui.screens.tems.rv.RvTeamsAdapter
import com.task.futbolapp.utils.loadCircleImage
import kotlinx.coroutines.launch

class ActivityViewTeams : AppCompatActivity() {
    private val teamsViewModel: TeamsViewModel by viewModels()
    private lateinit var binding: ActivityViewTeamsBinding
    private lateinit var rvTeams: RvTeamsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewTeamsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRV()
        initUiStateLifecycle()
        getTeam()
    }

    private fun initRV() {
        rvTeams = RvTeamsAdapter()
        binding.rvTeamsCompetition.adapter = rvTeams
        binding.rvTeamsCompetition.layoutManager = LinearLayoutManager(this)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initUiStateLifecycle() {
        lifecycleScope.launch {
            teamsViewModel.teams.collect { uiState ->
                with(binding) {
                    uiState.teams?.let { teams ->
                        tvTeamName.text = uiState.competition?.name
                        tvCode.text =
                            tvCode.context.getString(
                                R.string.team_code,
                                uiState.competition?.code
                            )
                        tvType.text =
                            tvType.context.getString(
                                R.string.tema_type,
                                uiState.competition?.type
                            )
                        val emblemUrl = uiState.competition?.emblem
                        if(emblemUrl != null){
                            ivEmblemCompetition.loadCircleImage(uiState.competition!!.emblem)
                        }else{
                            ivEmblemCompetition.loadCircleImage(R.drawable.image_emblem_not_found)
                        }
                        rvTeams.teams =
                            teams
                        rvTeams.notifyDataSetChanged()
                    }
                    pbTeams.visibility = if (uiState.isTeamsLoading) View.VISIBLE else View.INVISIBLE
                }
            }
        }
    }

    private fun getTeam() {
        val teamId = intent.extras?.getInt(TEAM_ID)
        teamId?.let {
            teamsViewModel.getTeams(teamId)
        }
    }

    companion object {
        const val TEAM_ID = "teamId"
    }
}