package com.yorick.sharednotes.data.local

import com.yorick.sharednotes.data.model.Account

object LocalAccountsDataProvider {
    val UserAccount =
        Account(
            id = 1L,
            firstName = "Rick",
            lastName = "Yo",
            phoneNumber = "+8613048682357",
            email = "yurui0216@gmail.com",
            altEmail = "yorick0216@outlook.com",
            avatar = "avatar_11",
            isCurrentAccount = true
        )
    val allUserContactAccounts = listOf(
        UserAccount,
        Account(
            id = 2L,
            firstName = "Tracy",
            lastName = "Alvarez",
            phoneNumber = "+8613088888888",
            email = "tracealvie@gmail.com",
            altEmail = "tracealvie@gravity.com",
            avatar = "avatar_1"
        ),
        Account(
            id = 3L,
            firstName = "Allison",
            lastName = "Trabucco",
            phoneNumber = "+8613066884448",
            email = "atrabucco222@gmail.com",
            altEmail = "atrabucco222@work.com",
            avatar = "avatar_3"
        ),
        Account(
            id = 4L,
            firstName = "Ali",
            lastName = "Connors",
            phoneNumber = "+8613018283868",
            email = "aliconnors@gmail.com",
            altEmail = "aliconnors@android.com",
            avatar = "avatar_5"
        ),
        Account(
            id = 5L,
            firstName = "Alberto",
            lastName = "Williams",
            phoneNumber = "+8613058689831",
            email = "albertowilliams124@gmail.com",
            altEmail = "albertowilliams124@chromeos.com",
            avatar = "avatar_0"
        ),
        Account(
            id = 6L,
            firstName = "Kim",
            lastName = "Alen",
            phoneNumber = "+8613681118222",
            email = "alen13@gmail.com",
            altEmail = "alen13@mountainview.gov",
            avatar = "avatar_7"
        ),
        Account(
            id = 7L,
            firstName = "Google",
            lastName = "Express",
            phoneNumber = "+8615832165488",
            email = "express@google.com",
            altEmail = "express@gmail.com",
            avatar = "avatar_express"
        ),
        Account(
            id = 8L,
            firstName = "Sandra",
            lastName = "Adams",
            phoneNumber = "+8613528486810",
            email = "sandraadams@gmail.com",
            altEmail = "sandraadams@textera.com",
            avatar = "avatar_2"
        ),
        Account(
            id = 9L,
            firstName = "Trevor",
            lastName = "Hansen",
            phoneNumber = "+8618028236810",
            email = "trevorhandsen@gmail.com",
            altEmail = "trevorhandsen@express.com",
            avatar = "avatar_8"
        ),
        Account(
            id = 10L,
            firstName = "Sean",
            lastName = "Holt",
            phoneNumber = "+8613728306511",
            email = "sholt@gmail.com",
            altEmail = "sholt@art.com",
            avatar = "avatar_6"
        ),
        Account(
            id = 11L,
            firstName = "Frank",
            lastName = "Hawkins",
            phoneNumber = "+8618723026432",
            email = "fhawkank@gmail.com",
            altEmail = "fhawkank@thisisme.com",
            avatar = "avatar_4"
        )
    )

    fun getContactAccountById(accountId: Long): Account {
        return allUserContactAccounts.first { it.id == accountId }
    }
}