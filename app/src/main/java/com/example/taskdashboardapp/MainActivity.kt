package com.example.taskdashboardapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskdashboardapp.presentation.adapter.UserAdapter

import com.example.taskdashboardapp.databinding.ActivityMainBinding
import com.example.taskdashboardapp.presentation.viewmodel.TaskViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: TaskViewModel by viewModels() // ViewModelProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.users.observe(this) { users ->
            val adapter = UserAdapter(users)
            binding.recyclerView.adapter = adapter
        }

        viewModel.error.observe(this) { errorMsg ->
            Toast.makeText(this, "Error: $errorMsg", Toast.LENGTH_SHORT).show()
        }
    }
}