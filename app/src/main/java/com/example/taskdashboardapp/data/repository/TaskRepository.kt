// TaskRepository.kt
package com.example.taskdashboardapp.data.repository

import com.example.taskdashboardapp.data.remote.RetrofitInstance
import com.example.taskdashboardapp.data.remote.dto.DashboardResponseDto

class TaskRepository {
    suspend fun getDashboard(): DashboardResponseDto {
        return RetrofitInstance.api.getDashboard()
    }
}
