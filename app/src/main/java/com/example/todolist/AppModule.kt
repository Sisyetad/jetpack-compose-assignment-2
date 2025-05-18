package com.example.todolist

import android.app.Application
import androidx.room.Room
import com.example.todolist.Data.Api.TodoApi
import com.example.todolist.Data.Datasrc.TodoDao
import com.example.todolist.Data.Datasrc.TodoDatabase
import com.example.todolist.Data.Repository.TodoRepository
import com.example.todolist.Data.Repository.TodoRepositoryImpl
import com.example.todolist.Domain.usecase.GetTodoDetailUseCase
import com.example.todolist.Domain.usecase.GetTodosUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): TodoApi = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(TodoApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application): TodoDatabase =
        Room.databaseBuilder(app, TodoDatabase::class.java, "todo_db").build()

    @Provides
    fun provideTodoDao(db: TodoDatabase): TodoDao = db.todoDao()

    @Provides
    fun provideRepository(api: TodoApi, dao: TodoDao): TodoRepository =
        TodoRepositoryImpl(api, dao)

    @Provides
    fun provideGetTodosUseCase(repo: TodoRepository) = GetTodosUseCase(repo)

    @Provides
    fun provideGetTodoDetailUseCase(repo: TodoRepository) = GetTodoDetailUseCase(repo)
}