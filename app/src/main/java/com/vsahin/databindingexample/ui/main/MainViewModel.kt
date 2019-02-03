package com.vsahin.databindingexample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.vsahin.databindingexample.data.Repository
import com.vsahin.databindingexample.data.Todo
import javax.inject.Inject

class MainViewModel @Inject constructor(repository: Repository) : ViewModel() {

    private val allTodos: MutableLiveData<List<Todo>> = repository.todos

    private val filter = MutableLiveData(Filter.ALL)
    val filteredTodos: LiveData<List<Todo>> = Transformations.switchMap(filter) { filter ->
        when (filter) {
            Filter.COMPLETED -> MutableLiveData<List<Todo>>(allTodos.value?.filter { it.completed })
            Filter.UNCOMPLETED -> MutableLiveData<List<Todo>>(allTodos.value?.filter { !it.completed })
            else -> allTodos
        }
    }

    fun setFilter(position: Int) {
        when (position) {
            0 -> this.filter.value= Filter.ALL
            1 -> this.filter.value = Filter.COMPLETED
            2 -> this.filter.value = Filter.UNCOMPLETED
        }
    }
}
