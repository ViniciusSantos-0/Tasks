package com.example.tasks.service.repository.local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class TaskDatabase : RoomDatabase() {
    companion object {
        private lateinit var INSTANCE: TaskDatabase

        fun getDatabase(context: Context): TaskDatabase {
            if (!Companion::INSTANCE.isInitialized) {
                synchronized(TaskDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context, TaskDatabase::class.java, "tasksDB")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}