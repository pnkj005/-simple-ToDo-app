package com.example.todoapp

import android.app.Application
import androidx.room.Room
import com.example.todoapp.db.TodoDatabase

class MainApplication:Application() {

    companion object{
        lateinit var tododatabase: TodoDatabase
    }

    override fun onCreate() {
        super.onCreate()
        tododatabase =
        Room.databaseBuilder(
            applicationContext, TodoDatabase::class.java,
            TodoDatabase.NAME
        ).build()
    }
}