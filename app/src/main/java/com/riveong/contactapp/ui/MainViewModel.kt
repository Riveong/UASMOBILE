package com.riveong.contactapp.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.riveong.contactapp.data.Contact
import com.riveong.contactapp.data.ContactRepository

class MainViewModel(application: Application) : ViewModel() {
    private val mContactRepository: ContactRepository = ContactRepository(application)
    fun getAllNotes(): LiveData<List<Contact>> = mContactRepository.getAllNotes()
}