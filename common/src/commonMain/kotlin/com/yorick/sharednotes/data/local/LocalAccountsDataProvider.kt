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
            firstName = "John",
            lastName = "Crayon",
            phoneNumber = "+8613088888888",
            email = "crayonjohn@gmail.com",
            altEmail = "crayonjohn@gravity.com",
            avatar = "avatar_2"
        ),
        Account(
            id = 3L,
            firstName = "Sandy",
            lastName = "Miao",
            phoneNumber = "+8613066884448",
            email = "miaosun666@gmail.com",
            altEmail = "miaosun666@work.com",
            avatar = "avatar_3"
        ),
        Account(
            id = 4L,
            firstName = "Kun",
            lastName = "Ai",
            phoneNumber = "+8613018283868",
            email = "aikun520@gmail.com",
            altEmail = "aikun520@outlook.com",
            avatar = "avatar_4"
        ),
        Account(
            id = 5L,
            firstName = "Lin",
            lastName = "Li",
            phoneNumber = "+8613058689831",
            email = "lilin123@gmail.com",
            altEmail = "lilin1234@126.com",
            avatar = "avatar_5"
        ),
        Account(
            id = 6L,
            firstName = "Kim",
            lastName = "Wang",
            phoneNumber = "+8613681118222",
            email = "wangwang88@gmail.com",
            altEmail = "wangwang88@163.com",
            avatar = "avatar_6"
        ),
        Account(
            id = 7L,
            firstName = "Bing",
            lastName = "Wang",
            phoneNumber = "+8615832165488",
            email = "wangbing99@gmail.com",
            altEmail = "wangbing99@126.com",
            avatar = "avatar_7"
        ),
        Account(
            id = 8L,
            firstName = "Sweet",
            lastName = "Qiu",
            phoneNumber = "+8613528486810",
            email = "erhao123@gmail.com",
            altEmail = "erhao123@163.com",
            avatar = "avatar_8"
        ),
        Account(
            id = 9L,
            firstName = "Crop",
            lastName = "Muverse",
            phoneNumber = "+8618028236810",
            email = "muversec123@gmail.com",
            altEmail = "muversec123@outlook.com",
            avatar = "avatar_9"
        ),
        Account(
            id = 10L,
            firstName = "Daze",
            lastName = "Kageri",
            phoneNumber = "+8613728306511",
            email = "kagerid@gmail.com",
            altEmail = "kagerid@outlook.com",
            avatar = "avatar_10"
        ),
        Account(
            id = 11L,
            firstName = "Rui",
            lastName = "Yu",
            phoneNumber = "+8618723026432",
            email = "2524964538@qq.com",
            altEmail = "yr964538@163.com",
            avatar = "avatar_0"
        )
    )

    fun getContactAccountById(accountId: Long): Account {
        return allUserContactAccounts.first { it.id == accountId }
    }
}