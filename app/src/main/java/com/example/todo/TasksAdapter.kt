package com.example.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.CheckBox

class TasksAdapter(
    private val tasks : MutableList<Task>

) : RecyclerView.Adapter<TasksAdapter.TaskViewHolder>(){
    class TaskViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
            val checkbox = itemView.findViewById<CheckBox>(R.id.checkbox)
        }
    var onEmptyState: ((isEmpty: Boolean) -> Unit)? = null
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
        holder.checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
            tasks[position].status = isChecked


        }
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
    fun addTask(task : Task) {
        tasks.add(task)
    }
}