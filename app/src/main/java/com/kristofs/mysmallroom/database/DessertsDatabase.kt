package com.kristofs.mysmallroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Desserts::class], version = 1, exportSchema = false)
abstract class DessertsDatabase: RoomDatabase() {

    abstract val dessertsDatabaseDao: DessertsDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: DessertsDatabase? = null

        fun getInstance(context: Context): DessertsDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    // Instantiate Database with RoomBuilder
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DessertsDatabase::class.java,
                        "desserts_history_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}