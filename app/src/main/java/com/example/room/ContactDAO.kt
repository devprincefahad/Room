package com.example.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDAO {

    //use coroutines to perform query operations on background/separate thread
    //if executed on main thread it will throw exception

    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contact")
    fun getContact(): LiveData<List<Contact>>
    //livedata will execute getContact on background thread

}