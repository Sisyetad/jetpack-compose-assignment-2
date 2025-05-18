package com.example.todolist.Domain.usecase

import com.example.todolist.Data.Repository.TodoRepository

class GetTodoDetailUseCase(private val repository: TodoRepository) {
    suspend operator fun invoke(id: Int) = repository.getTodoById(id)
}
