package com.task.futbolapp.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.futbolapp.data.api.retrtofit.RetrofitService
import com.task.futbolapp.ui.screens.competitions.uiState.CompetitionsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CompetitionsViewModel: ViewModel() {
    private val _competitions = MutableStateFlow(CompetitionsUiState())
    val competitions = _competitions.asStateFlow()

    private val retrofitApi by lazy{
        RetrofitService.getInstance()
    }
    init{
        viewModelScope.launch {
            getCompetitions()
        }
    }

    private suspend fun getCompetitions() {
        val competitions = retrofitApi.getCompetitions()
        val competitionsData = competitions.competitions
        _competitions.value = _competitions.value.copy(
            isLoading = false,
            competitions = competitionsData
        )
    }
}