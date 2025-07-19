// TaskViewModel.kt
package com.example.taskdashboardapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.taskdashboardapp.data.remote.dto.UserDto
import com.example.taskdashboardapp.data.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {

    private val repository = TaskRepository()

    private val _users = MutableLiveData<List<UserDto>>()
    val users: LiveData<List<UserDto>> = _users

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    init {
        fetchDashboard()
    }

    private fun fetchDashboard() {
        viewModelScope.launch {
            try {
                val response = repository.getDashboard()
                _users.value = response.users
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }
}
