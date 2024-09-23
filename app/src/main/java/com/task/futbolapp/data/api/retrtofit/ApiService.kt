package com.task.futbolapp.data.api.retrtofit

import com.task.futbolapp.data.api.models.Competition
import com.task.futbolapp.data.api.models.ResponseCompetitions
import com.task.futbolapp.data.api.models.ResponseTeams
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("competitions")
    suspend fun getCompetitions(): ResponseCompetitions

    @GET("competitions/{id}/teams")
    suspend fun getCompetition(@Path("id") id: Int): ResponseTeams
}