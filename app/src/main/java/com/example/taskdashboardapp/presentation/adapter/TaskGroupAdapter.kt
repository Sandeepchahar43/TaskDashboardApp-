package com.example.taskdashboardapp.presentation.adapter

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskdashboardapp.data.remote.dto.TaskGroup

class TaskGroupAdapter(private val groups: List<TaskGroup>) :
    RecyclerView.Adapter<TaskGroupAdapter.GroupViewHolder>() {

    inner class GroupViewHolder(private val view: TextView) :
        RecyclerView.ViewHolder(view) {
        fun bind(group: TaskGroup) {
            view.text = "${group.name} (${group.completedTasks}/${group.totalTasks} completed)"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val textView = TextView(parent.context)
        textView.setPadding(16, 8, 16, 8)
        return GroupViewHolder(textView)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.bind(groups[position])
    }

    override fun getItemCount() = groups.size
}
