package com.example.androidexercise_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexercise_recyclerview.databinding.ActivityMainBinding
import com.example.androidexercise_recyclerview.databinding.ItemTodoBinding

class TodoAdapter(
    //this adapter somehow needs to know which data it should set to which item
    //and to actually tell this adapter that we need to create another class(To-do data class) that
    //describes how to-do item of our list looks like
    var todos: List<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    private lateinit var binding: ItemTodoBinding
    inner class TodoViewHolder(binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    /**
     * it is called when the recyclerview needs a new view holder so for instance if the user
     * scrolls a little bit so that another item rose recycled and it now needs to create a new item which
     * is visible and in this function we will create the layout for a particular view so for a specific
     * item of our recyclerview
     *
     * we need to inflate our item to-do XML file to actually get it as a view that we can access in our kotlin file
     *
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        //can't do `from(this)` because we are not inside of an activity class, we are in adapter class so it does not know about
        //current context
        binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    /**
     * it returns how many items we have in our recycler view
     */
    override fun getItemCount(): Int {
        return todos.size
    }

    /**
     * purpose of this function is to bind the data to our items so this function will be
     * used to take the data from our `todos' list in line #11 and set it to the corresponding view
     *
     * @param holder - to access the view inside of that view holder so that text view and their checkbox in this case
     * @param position - it is the current position of the current index rather of that particular view that we are binding here
     *                   and we need to access our to-do list here at the same position to get the data about the to do statement
     *                   that should be at this place in our recyclerview
     *
     */
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        binding.tvTitle.text = todos[position].title
        binding.cbDone.isChecked = todos[position].isChecked
    }
}