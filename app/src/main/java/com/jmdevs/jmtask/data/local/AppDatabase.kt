package com.jmdevs.jmtasks.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Clase principal de la base de datos que configura Room.
 * Es el punto de acceso principal a la base de datos SQLite.
 *
 * Define todas las tablas y provee acceso a los DAOs.
 */
@Database(
    entities = [TaskEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    /**
     * Proporciona acceso al TaskDao para operaciones CRUD de tareas.
     */
    abstract fun taskDao(): TaskDao


}