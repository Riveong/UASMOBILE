package com.riveong.contactapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Contact::class],
    version = 1
)
abstract class ContactRoomDatabase: RoomDatabase() {
    abstract fun contactDAO(): ContactDAO

    companion object {
        @Volatile
        private var INSTANCE: ContactRoomDatabase? = null
        @JvmStatic
        fun getDatabase(context: Context): ContactRoomDatabase {
            if (INSTANCE == null) {
                synchronized(ContactRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ContactRoomDatabase::class.java, "note_database")
                        .build()
                }
            }
            return INSTANCE as ContactRoomDatabase
        }
    }
}