package com.kristofs.mysmallroom.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Model

@Entity(tableName = "desserts")
data class Desserts(
    @PrimaryKey(autoGenerate = true) val dessertID: Long,
    @ColumnInfo(name = "title") val dessertName: String,
    @ColumnInfo(name = "description") val dessertDescription: String
)