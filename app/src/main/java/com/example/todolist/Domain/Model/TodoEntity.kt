package com.example.todolist.Domain.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class TodoEntity(
    @PrimaryKey val id: Int,
    val userId: Int,
    val title: String,
    val completed: Boolean
) {
    fun toDomain() = Todo(id, userId, title, completed)
}

fun Todo.toEntity() = TodoEntity(id, userId, title, completed)
