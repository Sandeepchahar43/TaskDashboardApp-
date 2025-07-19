package com.example.taskdashboardapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskdashboardapp.data.remote.dto.InProgressTask
import com.example.taskdashboardapp.databinding.ItemInProgressTaskBinding

class InProgressTaskAdapter(private val tasks: List<InProgressTask>) :
    RecyclerView.Adapter<InProgressTaskAdapter.InProgressTaskViewHolder>() {

    inner class InProgressTaskViewHolder(private val binding: ItemInProgressTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(task: InProgressTask) {
            binding.taskTitle.text = task.title
            binding.taskProgressText.text = "${task.progress}%"
            binding.circularProgress.setProgressCompat(task.progress, true)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InProgressTaskViewHolder {
        val binding = ItemInProgressTaskBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return InProgressTaskViewHolder(binding)
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: InProgressTaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }
}
