package com.example.mylingo.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class customer(
    val Id:String,
    var Name:String,
    var username:String,
    var password:String,
    var EmailAddress:String,
    var Tel:String,
    var Address:String
 ): Parcelable