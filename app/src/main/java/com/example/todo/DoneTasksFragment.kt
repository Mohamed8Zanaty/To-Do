package com.example.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DoneTasksFragment(val tasks : MutableList<Task>) : Fragment() {
    lateinit var doneTasksRecycle : RecyclerView
    lateinit var adapter : DoneTasksAdapter
    lateinit var emptylist : ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_done_tasks,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        doneTasksRecycle = view.findViewById(R.id.done_tasks)
        doneTasksRecycle.layoutManager = LinearLayoutManager(requireContext())
        val doneTasks = tasks.filter{ it.status }
        adapter = DoneTasksAdapter(doneTasks.toMutableList())
        doneTasksRecycle.adapter = adapter
        adapter.onEmptyState = { isEmpty ->
            updateEmptyStateVisibility(isEmpty)
        }

    }
    private fun updateEmptyStateVisibility(isEmpty: Boolean) {
        if (isEmpty) {
            emptylist.visibility = View.VISIBLE
            doneTasksRecycle.visibility = View.GONE
        } else {
            emptylist.visibility = View.GONE
            doneTasksRecycle.visibility = View.VISIBLE
        }
    }
}