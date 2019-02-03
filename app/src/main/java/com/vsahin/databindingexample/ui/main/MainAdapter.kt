package com.vsahin.databindingexample.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.vsahin.databindingexample.data.Todo
import com.vsahin.databindingexample.databinding.ItemTodoBinding


class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private val todos: ArrayList<Todo> = ArrayList()

    override fun getItemCount(): Int = todos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemTodoBinding.inflate(
            LayoutInflater.from(parent.context)
        )
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val todo = todos[position]
        holder.binding.todo = todo
    }


    fun setTodos(todos: List<Todo>) {
        val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int = this@MainAdapter.todos.size

            override fun getNewListSize(): Int = todos.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                this@MainAdapter.todos[oldItemPosition].id == todos[newItemPosition].id

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                this@MainAdapter.todos[oldItemPosition] == todos[newItemPosition]
        })

        this.todos.clear()
        this.todos.addAll(todos)

        diffResult.dispatchUpdatesTo(this)
    }

    inner class MainViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)
}