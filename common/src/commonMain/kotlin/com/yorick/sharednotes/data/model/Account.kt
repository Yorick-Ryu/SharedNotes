package com.yorick.sharednotes.data.model

data class Account(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val altEmail: String,
    val avatar: String, // picture dir
    var isCurrentAccount: Boolean = false
) {
    val fullName: String = "$firstName $lastName"
}