package com.jmdevs.jmtasks.domain.repository

import com.jmdevs.jmtasks.data.local.TaskEntity
import kotlinx.coroutines.flow.Flow

/**
 * Interfaz que define las operaciones del repositorio de tareas.
 */
interface TaskRepository {
    fun getAllTasks(): Flow<List<TaskEntity>>
    fun getTasksByCompletion(isCompleted: Boolean): Flow<List<TaskEntity>>
    fun searchTasks(query: String): Flow<List<TaskEntity>>
    suspend fun insertTask(task: TaskEntity)
    suspend fun updateTask(task: TaskEntity)
    suspend fun deleteTask(task: TaskEntity)
    suspend fun deleteCompletedTasks()
    suspend fun deleteAllTasks()
}