package com.riveong.contactapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.riveong.contactapp.data.Contact
import com.riveong.contactapp.databinding.CardBinding
import com.riveong.contactapp.utils.ContactDiffCallback

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>(){
    private val listCotacts = ArrayList<Contact>()
    fun setListNotes(listNotes: List<Contact>) {
        val diffCallback = ContactDiffCallback(this.listCotacts, listNotes)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listCotacts.clear()
        this.listCotacts.addAll(listCotacts)
        diffResult.dispatchUpdatesTo(this)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = CardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(listCotacts[position])
    }
    override fun getItemCount(): Int {
        return listCotacts.size
    }
    inner class ContactViewHolder(private val binding: CardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact) {
            with(binding) {
                tvItemName.text = contact.nama
                idTVNumber.text = contact.nomor
            }
        }
    }
}
