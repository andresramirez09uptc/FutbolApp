package com.task.futbolapp.ui.screens.competitions.uiState

import com.task.futbolapp.data.api.models.Competition

data class CompetitionsUiState (
    val competitions: List<Competition>? = null,
    val isLoading: Boolean = true
)