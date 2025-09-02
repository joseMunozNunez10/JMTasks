package com.jmdevs.jmtasks.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * Representa una tarea en la base de datos.
 *
 * @property id Identificador único de la tarea (autogenerado)
 * @property title Título de la tarea (obligatorio)
 * @property description Descripción opcional de la tarea
 * @property isCompleted Indica si la tarea está completada
 * @property priority Prioridad de la tarea (0: baja, 1: media, 2: alta)
 * @property dueDate Fecha límite opcional de la tarea
 * @property createdAt Fecha de creación de la tarea
 */
@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String,
    val description: String? = null,
    val isCompleted: Boolean = false,
    val priority: Int = 0,
    val dueDate: Long? = null,
    val createdAt: Long = System.currentTimeMillis()
)