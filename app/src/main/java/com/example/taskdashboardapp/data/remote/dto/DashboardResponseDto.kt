// DashboardResponseDto.kt
package com.example.taskdashboardapp.data.remote.dto

data class DashboardResponseDto(
    val users: List<UserDto>
)

data class UserDto(
    val id: Int,
    val name: String,
    val avatar: String,
    val taskStats: TaskStats,
    val inProgressTasks: List<InProgressTask>,
    val taskGroups: List<TaskGroup>
)

data class TaskStats(val completedPercent: Int)
data class InProgressTask(val title: String, val type: String, val progress: Int)
data class TaskGroup(val name: String, val totalTasks: Int, val completedTasks: Int)
