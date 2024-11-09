package com.example.todoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date


class TodViewModel:ViewModel() {
 val todoDao = MainApplication.tododatabase.getTodoDao()
    val todoList: LiveData<List<Todo>> = todoDao.getAllTodo()


    fun addTodo(title: String) {
        viewModelScope.launch(Dispatchers.IO ) {
            todoDao.addTodo(Todo(title = title,
                createdAt =  Date(System.currentTimeMillis())))
        }
    }

    fun deleteTodo(id: Int) {
        viewModelScope.launch(Dispatchers.IO ){
            todoDao.deletetodo(id)
        }

    }
}