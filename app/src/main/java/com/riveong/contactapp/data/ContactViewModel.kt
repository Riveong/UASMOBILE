package com.riveong.contactapp.data

import android.app.Application
import androidx.lifecycle.ViewModel
import com.riveong.contactapp.data.Contact
import com.riveong.contactapp.data.ContactRepository

class ContactViewModel(application: Application) : ViewModel() {
    private val mContactRepository: ContactRepository = ContactRepository(application)
    fun insert(contact: Contact) {
        mContactRepository.insert(contact)
    }
}