package com.riveong.contactapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.riveong.contactapp.data.Contact

class ContactDiffCallback(private val oldContactList: List<Contact>, private val newContactList: List<Contact>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldContactList.size
    override fun getNewListSize(): Int = newContactList.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldContactList[oldItemPosition].id == newContactList[newItemPosition].id
    }
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldContact = oldContactList[oldItemPosition]
        val newContact = newContactList[newItemPosition]
        return oldContact.nama == newContact.nama && oldContact.nomor == newContact.nomor
    }
}