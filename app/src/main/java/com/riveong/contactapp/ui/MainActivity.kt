package com.riveong.contactapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.riveong.contactapp.R
import com.riveong.contactapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _activityMainBinding: ActivityMainBinding? = null
    private val binding get() = _activityMainBinding
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        adapter = ContactAdapter()
        binding?.rcy?.layoutManager = LinearLayoutManager(this)
        binding?.rcy?.setHasFixedSize(true)
        binding?.rcy?.adapter = adapter

        binding?.BtnAdd?.setOnClickListener {
            val intent = Intent(this@MainActivity, ContactAddUpdateActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _activityMainBinding = null
    }
}