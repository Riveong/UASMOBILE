package com.riveong.contactapp.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Contact (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var id: Int = 0,

    @ColumnInfo(name="nama")
    var nama: String = "joe",

    @ColumnInfo(name="nomor")
    var nomor: String = "213123213"

    ) : Parcelable