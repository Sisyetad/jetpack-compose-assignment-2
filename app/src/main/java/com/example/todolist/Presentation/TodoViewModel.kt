package com.example.todolist.Presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.Domain.Model.Todo
import com.example.todolist.Domain.usecase.GetTodosUseCase
import com.example.todolist.Domain.usecase.InsertTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class TodoListState {
    object Loading : TodoListState()
    data class Success(val todos: List<Todo>) : TodoListState()
    data class Error(val message: String) : TodoListState()
}

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val getTodosUseCase: GetTodosUseCase,
    private val insertTodoUseCase: InsertTodoUseCase
) : ViewModel() {

    var state by mutableStateOf<TodoListState>(TodoListState.Loading)
        private set

    init {
        loadTodos()
    }

    private fun loadTodos() {
        viewModelScope.launch {
            state = try {
                val todos = getTodosUseCase()
                TodoListState.Success(todos)
            } catch (e: Exception) {
                TodoListState.Error("Failed to load todos")
            }
        }
    }
    fun insertTodo(todo: Todo) {
        viewModelScope.launch {
            insertTodoUseCase(todo)
        }
    }

}
