package com.example.todolist.Data.Repository

import com.example.todolist.Domain.Model.Todo

interface TodoRepository {
    suspend fun getTodos(): List<Todo>
    suspend fun getTodoById(id: Int): Todo?
    suspend fun insertTodo(todo: Todo)
}
