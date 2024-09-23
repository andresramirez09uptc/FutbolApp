package com.task.futbolapp.data.api.models

data class Team(
    val area: Area,
    val id: Int,
    val name: String,
    val shortName: String,
    val tla: String,
    val crest: String,
    val address: String,
    val website: String,
    val founded: Int,
    val clubColors: String,
    val venue: String,
    val runningCompetitions: List<RunningCompetition>,
    val coach: Coach,
    val squad: List<Player>,
    val lastUpdated: String
)
