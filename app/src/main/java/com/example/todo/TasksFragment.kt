package com.example.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TasksFragment(val tasks : MutableList<Task>) : Fragment() {
    lateinit var tasksRecycle : RecyclerView
    lateinit var adapter: TasksAdapter
    lateinit var emptylist : ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasks,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tasksRecycle = view.findViewById(R.id.tasks)
        tasksRecycle.layoutManager = LinearLayoutManager(requireContext())
        val tasks2 = tasks.filter{ !it.status }
        adapter = TasksAdapter(tasks2.toMutableList())
        tasksRecycle.adapter = adapter
        adapter.onEmptyState = { isEmpty ->
            updateEmptyStateVisibility(isEmpty)
        }


    }
    private fun updateEmptyStateVisibility(isEmpty: Boolean) {
        if (isEmpty) {
            emptylist.visibility = View.VISIBLE
            tasksRecycle.visibility = View.GONE
        } else {
            emptylist.visibility = View.GONE
            tasksRecycle.visibility = View.VISIBLE
        }
    }
}