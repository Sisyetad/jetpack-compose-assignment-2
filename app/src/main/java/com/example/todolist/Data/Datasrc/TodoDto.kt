package com.example.todolist.Data.Datasrc

import com.example.todolist.Domain.Model.Todo

data class TodoDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
) {
    fun toDomain() = Todo(id, userId, title, completed)
}


fun Todo.toDto(): TodoDto {
    return TodoDto(
        id = this.id,
        userId = this.userId,
        title = this.title,
        completed = this.completed
    )
}
