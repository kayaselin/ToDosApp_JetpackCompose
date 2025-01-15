package com.example.todos.di

import android.content.Context
import androidx.room.Room
import com.example.todos.data.datasource.ToDoDataSource
import com.example.todos.data.repo.ToDoRepository
import com.example.todos.room.ToDoDao
import com.example.todos.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideNotlarRepository(tds:ToDoDataSource) : ToDoRepository {
        return ToDoRepository(tds)
    }

    @Provides
    @Singleton
    fun provideNotlarDataSource(tdao:ToDoDao) : ToDoDataSource {
        return ToDoDataSource(tdao)
    }

    @Provides
    @Singleton
    fun provideNotlarDao(@ApplicationContext context: Context): ToDoDao{
        val vt = Room.databaseBuilder(context,Veritabani::class.java,"ToDos.sqlite")
            .createFromAsset("ToDos.sqlite").build()
        return vt.getToDoDao()
    }
}