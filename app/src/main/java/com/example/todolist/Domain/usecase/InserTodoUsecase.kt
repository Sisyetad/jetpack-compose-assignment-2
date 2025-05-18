package com.example.todolist.Domain.usecase

import com.example.todolist.Data.Repository.TodoRepository
import com.example.todolist.Domain.Model.Todo
import javax.inject.Inject

class InsertTodoUseCase @Inject constructor(
    private val repository: TodoRepository
) {
    suspend operator fun invoke(todo: Todo) {
        repository.insertTodo(todo)
    }
}
