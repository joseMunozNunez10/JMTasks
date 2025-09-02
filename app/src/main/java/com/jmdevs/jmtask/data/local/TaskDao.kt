package com.jmdevs.jmtasks.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) para las operaciones de la base de datos de tareas.
 *
 * Actúa como la interfaz entre la aplicación y la base de datos Room.
 * Define todas las operaciones CRUD (Create, Read, Update, Delete) para las tareas.
 */
@Dao
interface TaskDao {

    // CREATE - Insertar una nueva tarea
    @Insert
    suspend fun insertTask(task: TaskEntity)

    // READ - Obtener todas las tareas (ordenadas por fecha de creación)
    @Query("SELECT * FROM tasks ORDER BY createdAt DESC")
    fun getAllTasks(): Flow<List<TaskEntity>>

    // READ - Obtener tareas por estado de completado
    @Query("SELECT * FROM tasks WHERE isCompleted = :isCompleted ORDER BY createdAt DESC")
    fun getTasksByCompletion(isCompleted: Boolean): Flow<List<TaskEntity>>

    // READ - Buscar tareas por título
    @Query("SELECT * FROM tasks WHERE title LIKE '%' || :query || '%' ORDER BY createdAt DESC")
    fun searchTasks(query: String): Flow<List<TaskEntity>>

    // UPDATE - Actualizar una tarea existente
    @Update
    suspend fun updateTask(task: TaskEntity)

    // DELETE - Eliminar una tarea
    @Delete
    suspend fun deleteTask(task: TaskEntity)

    // DELETE - Eliminar todas las tareas completadas
    @Query("DELETE FROM tasks WHERE isCompleted = 1")
    suspend fun deleteCompletedTasks()

    // DELETE - Eliminar todas las tareas
    @Query("DELETE FROM tasks")
    suspend fun deleteAllTasks()
}