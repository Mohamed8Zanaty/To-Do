package com.example.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class AddTaskFragment(val tasksAdapter: TasksAdapter) : Fragment() {
    lateinit var task : EditText
    lateinit var saveBtn : Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        task = view.findViewById(R.id.etTask)
        saveBtn = view.findViewById(R.id.btnSave)
        saveBtn.setOnClickListener {
            if(task.text != null) {
                tasksAdapter.addTask(Task(task.text.toString(), false))

            }
        }
    }

}