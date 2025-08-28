package com.example.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class DoneTasksAdapter(private val tasks : List<Task>)
    : RecyclerView.Adapter<DoneTasksAdapter.TaskViewHolder>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)

            .inflate(R.layout.task, parent, false)

        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: TaskViewHolder,
        position: Int
    ) {
        val task = tasks[position]
        holder.checkbox.text = task.text
        holder.checkbox.isChecked = task.status
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    class TaskViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val checkbox = itemView.findViewById<CheckBox>(R.id.checkbox)
    }
}