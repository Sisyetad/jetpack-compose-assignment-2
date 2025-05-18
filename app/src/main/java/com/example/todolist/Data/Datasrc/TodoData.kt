package com.example.todolist.Data.Datasrc

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolist.Domain.Model.TodoEntity

@Database(entities = [TodoEntity::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}