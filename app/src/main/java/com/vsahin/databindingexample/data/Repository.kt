package com.vsahin.databindingexample.data

import androidx.lifecycle.MutableLiveData
import dagger.Reusable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import javax.inject.Inject
import javax.inject.Singleton

@Reusable
class Repository @Inject constructor(private val service: RetrofitService) {

    val todos: MutableLiveData<List<Todo>>
        get() {
            val todos = MutableLiveData<List<Todo>>()
            service.todos.enqueue(object : Callback<List<Todo>> {
                override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                    todos.postValue(response.body())
                }

                override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                    todos.postValue(null)
                }
            })

            return todos
        }

    fun getTodo(id: String): MutableLiveData<Todo> {
        val todo = MutableLiveData<Todo>()
        service.getTodo(id).enqueue(object : Callback<Todo> {
            override fun onResponse(call: Call<Todo>, response: Response<Todo>) {
                todo.postValue(response.body())
            }

            override fun onFailure(call: Call<Todo>, t: Throwable) {
            }
        })

        return todo
    }
}
