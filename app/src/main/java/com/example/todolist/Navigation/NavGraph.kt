package com.example.todolist.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todolist.Presentation.AddTodoScreen
import com.example.todolist.Presentation.TodoDetailScreen
import com.example.todolist.Presentation.TodoListScreen

@Composable
fun NavGraph(startDestination: String = "list") {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable("list") {
            TodoListScreen(navController)
        }
        composable("detail/{id}", arguments = listOf(navArgument("id") { type = NavType.IntType })) {
            val id = it.arguments?.getInt("id") ?: 0
            TodoDetailScreen(id = id, navController = navController)
        }

        composable("add") {
            AddTodoScreen(navController)
        }

    }
}
