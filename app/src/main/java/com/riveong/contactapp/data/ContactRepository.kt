package com.riveong.contactapp.data

import android.app.Application
import androidx.lifecycle.LiveData
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ContactRepository(application: Application) {
    private val mContactDAO: ContactDAO
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()
    init {
        val db = ContactRoomDatabase.getDatabase(application)
        mContactDAO = db.contactDAO()
    }
    fun getAllNotes(): LiveData<List<Contact>> = mContactDAO.getAllContact()
    fun insert(contact: Contact) {
        executorService.execute { mContactDAO.insert(contact) }
    }
}