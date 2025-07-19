package com.example.taskdashboardapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taskdashboardapp.data.remote.dto.UserDto
import com.example.taskdashboardapp.databinding.ItemTaskBinding

class UserAdapter(private val users: List<UserDto>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: UserDto) {
            binding.taskTitle.text = user.name
            binding.taskDescription.text = "Completed: ${user.taskStats.completedPercent}%"

            Glide.with(binding.root.context)
                .load(user.avatar)
                .circleCrop() //
                .into(binding.avatarImage)


            // InProgressTasks
            binding.inProgressRecyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = InProgressTaskAdapter(user.inProgressTasks)
            }

            // TaskGroups
            binding.taskGroupRecyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = TaskGroupAdapter(user.taskGroups)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }
}
