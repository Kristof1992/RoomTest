package com.kristofs.mysmallroom.dessertstracker

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kristofs.mysmallroom.database.DessertsDatabaseDao

class DessertsInventoryViewModelFactory(
    private val dataSource: DessertsDatabaseDao,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DessertsInventoryViewModel::class.java)) {
            return DessertsInventoryViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
