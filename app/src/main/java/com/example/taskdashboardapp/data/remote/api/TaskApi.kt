package com.example.taskdashboardapp.data.remote.api

import com.example.taskdashboardapp.data.remote.dto.DashboardResponseDto
import retrofit2.http.GET

interface TaskApi {
    @GET("ca4357ec-fb38-4c36-ae92-d54769a6e010")
    suspend fun getDashboard(): DashboardResponseDto
}