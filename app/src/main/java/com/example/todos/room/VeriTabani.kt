package com.example.todos.room


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todos.data.entity.Notlar

@Database(entities = [Notlar::class], version = 1)
abstract class Veritabani : RoomDatabase() {
    abstract fun getToDoDao() : ToDoDao
}