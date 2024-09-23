package com.task.futbolapp.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.futbolapp.data.api.retrtofit.RetrofitService
import com.task.futbolapp.ui.screens.tems.uiState.TeamsUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TeamsViewModel: ViewModel() {
    private val _teams = MutableStateFlow(TeamsUIState())
    val teams = _teams.asStateFlow()

    private val retrofitApi by lazy{
        RetrofitService.getInstance()
    }


    fun getTeams(id: Int){
        viewModelScope.launch {
            val response = retrofitApi.getCompetition(id)
            val teams = response.teams
            _teams.value = _teams.value.copy(
                teams = teams,
                isTeamsLoading = false,
                competition = response.competition
            )
        }

    }
}