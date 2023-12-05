package com.riveong.contactapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.riveong.contactapp.R
import com.riveong.contactapp.data.Contact
import com.riveong.contactapp.data.ContactViewModel
import com.riveong.contactapp.databinding.ActivityContactAddUpdateBinding

class ContactAddUpdateActivity : AppCompatActivity() {

    private var isEdit = false
    var contact: Contact? = null
    private lateinit var contactAddUpdateActivity: ContactViewModel
    private var _activityNoteAddUpdateBinding: ActivityContactAddUpdateBinding? = null
    private val binding get() = _activityNoteAddUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityNoteAddUpdateBinding = ActivityContactAddUpdateBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        contactAddUpdateActivity = obtainViewModel(this@ContactAddUpdateActivity)


        binding?.btnSubmit?.setOnClickListener {
            val Name = binding?.edtNama?.text.toString().trim()
            val Number = binding?.edtNomor?.text.toString().trim()
            when {
                Name.isEmpty() -> {
                    Toast.makeText(this,"masukan data dengan lengkap!",Toast.LENGTH_SHORT).show()
                }
                Number.isEmpty() -> {
                    Toast.makeText(this,"masukan data dengan lengkap!",Toast.LENGTH_SHORT).show()
                }
                else -> {
                    contact?.let {contact
                        contact?.nama = Name
                        contact?.nomor = Number

                    }

                    contactAddUpdateActivity.insert(contact as Contact)


                }
            }
            finish()

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _activityNoteAddUpdateBinding = null
    }
    private fun obtainViewModel(activity: AppCompatActivity): ContactViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[ContactViewModel::class.java]
    }
}