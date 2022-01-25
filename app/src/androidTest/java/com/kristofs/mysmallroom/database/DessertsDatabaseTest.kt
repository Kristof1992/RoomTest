package com.kristofs.mysmallroom.database

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Before
import java.lang.NullPointerException
import kotlin.jvm.Throws

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class DessertsDatabaseTest {

    private lateinit var dessertsDao: DessertsDatabaseDao
    private lateinit var db: DessertsDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, DessertsDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        dessertsDao = db.dessertsDatabaseDao
    }

    @Test
    @Throws(NullPointerException::class)
    fun checkDbInstance() {
        dessertsDao
        TestCase.assertNotNull(dessertsDao)
    }
}