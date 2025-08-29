package com.example.todo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val fab: FloatingActionButton = findViewById(R.id.fabAddTask)
        var tasks = mutableListOf<Task>()
        val tasksAdapter = TasksAdapter(tasks)

        fab.setOnClickListener {
            loadFragment(AddTaskFragment(tasksAdapter))
        }

        if (savedInstanceState == null) {
            loadFragment(TasksFragment(tasks))
        }

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_Tasks -> {
                    loadFragment(TasksFragment(tasks))
                    true
                }
                R.id.nav_DoneTasks -> {
                    loadFragment(DoneTasksFragment(tasks))
                    true
                }
                else -> false
            }
        }




    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
