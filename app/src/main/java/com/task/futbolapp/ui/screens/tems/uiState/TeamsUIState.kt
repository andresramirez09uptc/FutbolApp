package com.task.futbolapp.ui.screens.tems.uiState

import com.task.futbolapp.data.api.models.CompetitionTeam
import com.task.futbolapp.data.api.models.Team

data class TeamsUIState(
    val teams: List<Team> = emptyList(),
    val isTeamsLoading: Boolean = true,
    val competition: CompetitionTeam? = null
)
