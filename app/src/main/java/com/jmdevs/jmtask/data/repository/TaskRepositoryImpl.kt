package com.jmdevs.jmtasks.data.repository

import com.jmdevs.jmtasks.data.local.TaskDao
import com.jmdevs.jmtasks.data.local.TaskEntity
import com.jmdevs.jmtasks.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl constructor(  // ← QUITA @Inject
    private val taskDao: TaskDao
) : TaskRepository {

    override fun getAllTasks(): Flow<List<TaskEntity>> =
        taskDao.getAllTasks()

    override fun getTasksByCompletion(isCompleted: Boolean): Flow<List<TaskEntity>> =
        taskDao.getTasksByCompletion(isCompleted)

    override fun searchTasks(query: String): Flow<List<TaskEntity>> =
        taskDao.searchTasks(query)

    override suspend fun insertTask(task: TaskEntity) =
        taskDao.insertTask(task)

    override suspend fun updateTask(task: TaskEntity) =
        taskDao.updateTask(task)

    override suspend fun deleteTask(task: TaskEntity) =
        taskDao.deleteTask(task)

    override suspend fun deleteCompletedTasks() =
        taskDao.deleteCompletedTasks()

    override suspend fun deleteAllTasks() =
        taskDao.deleteAllTasks()
}