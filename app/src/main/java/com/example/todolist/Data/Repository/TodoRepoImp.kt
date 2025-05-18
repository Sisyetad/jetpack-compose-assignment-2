package com.example.todolist.Data.Repository

import com.example.todolist.Data.Api.TodoApi
import com.example.todolist.Data.Datasrc.TodoDao
import com.example.todolist.Data.Datasrc.toDto
import com.example.todolist.Domain.Model.Todo
import com.example.todolist.Domain.Model.toEntity
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val api: TodoApi,
    private val dao: TodoDao
) : TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        return try {
            val todos = api.getTodos().map { it.toDomain() }
            dao.insertAll(todos.map { it.toEntity() })
            todos
        } catch (e: Exception) {
            dao.getAll().map { it.toDomain() }
        }
    }

    override suspend fun getTodoById(id: Int): Todo? = dao.getById(id)?.toDomain()
    override suspend fun insertTodo(todo: Todo) {
        api.insertTodo(todo.toDto())
        dao.insertTodo(todo.toEntity())
    }

}