package com.task.futbolapp.data.api.models

data class ResponseTeams(
    val count: Int,
    val filters: Filters,
    val competition: CompetitionTeam,
    val season: CurrentSeason,
    val teams: List<Team>
)
