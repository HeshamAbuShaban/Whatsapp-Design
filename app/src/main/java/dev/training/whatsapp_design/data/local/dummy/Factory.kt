package dev.training.whatsapp_design.data.local.dummy

object Factory {

    val listOfChats: List<User>
        get() {
            return listOf(
                User(
                    1, null, "Hesham AbuShaban", "Hey, Whats up!", "2023/9/28", 1
                ),
                User(
                    2, null, "Baker AbuShaban", "Hey, Where are you!?", "2023/9/25", 0
                ),
                User(
                    3, null, "Mona AbuShaban", "Hey, Check this out", "2023/9/28", 4
                ),
                User(
                    4, null, "Yaz-an AbuShaban", "Hey, Do you wanna play", "2023/9/26", 1
                ),
            )
        }
}