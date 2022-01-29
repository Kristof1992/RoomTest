package com.kristofs.mysmallroom.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update



@Dao
interface DessertsDatabaseDao {
    @Insert
    fun insert(dessert: Desserts)

    @Update
    fun update(dessert: Desserts)

    @Query("SELECT * FROM desserts ORDER BY dessertID ASC")
    fun getAll(): List<Desserts>

    @Query("SELECT * FROM desserts ORDER BY dessertID ASC LIMIT 1")
    fun getFirstDessert() : Desserts?

    @Query("DELETE FROM desserts")
    fun deleteAll(): Int
}