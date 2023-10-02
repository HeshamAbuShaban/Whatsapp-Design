package dev.training.whatsapp_design.data.local.dummy

object Factory {

    val listOfChats: List<User>
        get() = listOf(
            User(
                1, null, "Hesham AbuShaban", "Hey, Whats up!", "2023/9/28", 1
            ),
            User(
                2, null, "Baker AbuShaban", "Hey, Where are you!?", "2023/9/25", 0
            ),

            User(
                3,
                null,
                "Mo-taz Hesham Mohamed Ali AbuShaban",
                "Hey, Check this out",
                "2023/9/28",
                4
            ),

            User(
                4, null, "Yaz-an AbuShaban", "Hey, Do you wanna play", "2023/9/26", 1
            ),
            User(
                5, null, "Yossef AbuShaban", "Hey, Do you wanna play", "2023/9/26", 1
            ),

            User(
                6, null, "Omar AbuShaban", "Hey, Do you wanna play", "2023/9/26", 1
            ),

            User(
                7, null, "Bader AbuShaban", "Hey, Do you wanna play", "2023/9/26", 1
            ),
            User(
                8, null, "Mohamed AbuShaban", "Hey, Do you wanna play", "2023/9/26", 1
            ),
            User(
                9, null, "Was-sam AbuShaban", "Hey, Do you wanna play", "2023/9/26", 1
            ),
            User(
                10, null, "Haitham AbuShaban", "Hey, Do you wanna play", "2023/9/26", 1
            ),
        )

    val listOfCalls: List<Call>
        get() = listOf(
            Call(
                null,
                "Mom-en Ses-alem",
                0,
                1,
                1,
                "today,2023-10-1"
            ),
            Call(
                null,
                "Omar AbuSha-nab",
                0,
                1,
                5,
                "2 month ago,2023-8-4"
            ),
            Call(
                null,
                "Hesham AbuShaban",
                1,
                0,
                1,
                "today,2023-10-1"
            ),
            Call(
                null,
                "Baker AbuShaban",
                0,
                1,
                1,
                "last month,2023-9-1"
            ),
            Call(
                null,
                "Mum💖",
                0,
                1,
                3,
                "last month,2023-9-28"
            ),
            Call(
                null,
                "Dad\uD83C\uDF39",
                0,
                1,
                3,
                "last month,2023-9-28"
            ),
            Call(
                null,
                "Omar AbuSha-nab",
                1,
                0,
                2,
                "2 month ago,2023-8-4"
            ),
            Call(
                null,
                "Omar AbuSha-nab",
                1,
                1,
                5,
                "2 month ago,2023-8-4"
            ),
            Call(
                null,
                "Fares F",
                1,
                1,
                2,
                "year ago,2022-10-20"
            ),
        )
}