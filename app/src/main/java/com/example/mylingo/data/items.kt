package com.example.mylingo.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class items(
    val id:String,
    val height: Int,
    //  val likes:Int,
    val description:String?,
    val user: itemsUser,
    val urls: itemsUrls,

    ): Parcelable {
    @Parcelize
    data class itemsUser(
        val username:String,
        val name:String
    ): Parcelable {
        val attributionUrl get() = "https://unsplash.com/$username?utm_source=ImageSearchApp&utm_medium=referral"
    }
    @Parcelize
    data class itemsUrls(
        val raw:String,
        val full:String,
        val regular:String,
        val small:String,
        val thumb:String
    ): Parcelable {
    }
}