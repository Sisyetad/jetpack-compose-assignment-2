package com.example.todolist.Domain.usecase

import com.example.todolist.Data.Repository.TodoRepository

class GetTodosUseCase(private val repository: TodoRepository) {
    suspend operator fun invoke() = repository.getTodos()
}