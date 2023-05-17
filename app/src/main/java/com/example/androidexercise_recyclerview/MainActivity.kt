package com.example.androidexercise_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidexercise_recyclerview.databinding.ActivityMainBinding

/**
 * Steps
 * 1. Add dependency
 * 2. Create recycler view in main layout
 * 3. Create item layout for recycler view
 * 4. Create Adapter
 * 
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var todoList = mutableListOf(
            Todo("Follow AndroidDevs", false),
            Todo("Learn about RecyclerView", true),
            Todo("Feed my cat", false),
            Todo("Prank my boss", false),
            Todo("Eat some curry", true),
            Todo("Ask my crush out", false),
            Todo("Take a shower", false)
        )

        val adapter = TodoAdapter(todoList)
        binding.apply {
            rvTodo.adapter = adapter
            rvTodo.layoutManager = LinearLayoutManager(this@MainActivity)

            btnAddTodo.setOnClickListener {
                val title = etTodo.text.toString()
                val todo = Todo(title, false)
                todoList.add(todo)
                //this will update whole recycler view
//                adapter.notifyDataSetChanged()
                adapter.notifyItemInserted(todoList.size - 1)
            }
        }

    }
}