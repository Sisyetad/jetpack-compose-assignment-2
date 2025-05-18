package com.example.todolist.Presentation

import androidx.lifecycle.ViewModel
import com.example.todolist.Domain.Model.Todo
import com.example.todolist.Domain.usecase.GetTodoDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoDetailViewModel @Inject constructor(
    private val getTodoDetailUseCase: GetTodoDetailUseCase
) : ViewModel() {
    suspend fun getTodoDetail(id: Int): Todo? = getTodoDetailUseCase(id)
}