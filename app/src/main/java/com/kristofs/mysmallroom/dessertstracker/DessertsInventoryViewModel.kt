package com.kristofs.mysmallroom.dessertstracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.kristofs.mysmallroom.database.Desserts
import com.kristofs.mysmallroom.database.DessertsDatabaseDao
import kotlinx.coroutines.*
import java.lang.NullPointerException

class DessertsInventoryViewModel(
    val database: DessertsDatabaseDao,
    application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var dessert = MutableLiveData<Desserts?>()

    private val desserts = database.getAll()

//    val currentDessertText = dessert.toString()

    init {
        intializeDessert()
    }

    private fun intializeDessert() {
        uiScope.launch {
            dessert.value = getDessertFromDatabase()
        }
    }

    private suspend fun getDessertFromDatabase(): Desserts? {
        return withContext(Dispatchers.IO) {
            var dessert = database.getFirstDessert()
            if (dessert == null) throw NullPointerException("Nothing returned program crashed!")
            dessert // last statement is the actual object that's returned
        }
    }

    // Deletes current instance then all data in DB

    fun onClear() {
        uiScope.launch {
            clear()
            dessert.value = null
        }
    }


    suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.deleteAll()
        }
    }


    fun onStart() {
        uiScope.launch {
            val newDessert = Desserts(1, "Chocolate Cake", "A wonderful french choco cake")
            insert(newDessert)
//            dessert.value = getTonightFromDatabase()
        }
    }

    private suspend fun insert(dessert: Desserts) {
        withContext(Dispatchers.IO) {
            database.insert(dessert)
        }
    }


}