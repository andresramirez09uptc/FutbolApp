package com.task.futbolapp.data.api.models

data class Competition(
    val id: Int,
    val area: Area,
    val name: String,
    val code: String,
    val type: String,
    val emblem: String,
    val plan: String,
    val currentSeason: CurrentSeason,
    val numberOfAvailableSeasons: Int,
    val lastUpdated: String
)
