package com.example.todolist.Data.Api

import com.example.todolist.Data.Datasrc.TodoDto
import com.example.todolist.Domain.Model.Todo
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TodoApi {
    @GET("todos")
    suspend fun getTodos(): List<TodoDto>
    @POST("todo")
    suspend fun insertTodo(@Body todo: TodoDto): Response<Unit>

}
