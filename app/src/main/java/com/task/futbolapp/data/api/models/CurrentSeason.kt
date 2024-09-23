package com.task.futbolapp.data.api.models

import java.time.LocalDate

data class CurrentSeason(
    val id: Int,
    val startDate: String,
    val endDate: String,
    val currentMatchday: Int,
    val winner: Any?
)
