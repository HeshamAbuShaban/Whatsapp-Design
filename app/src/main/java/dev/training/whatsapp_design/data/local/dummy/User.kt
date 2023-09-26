package dev.training.whatsapp_design.data.local.dummy

import android.graphics.Bitmap

data class User(
    val id:Int,
    val img:Bitmap,
    val name:String,
    val recentMessage:String,
    val recentMessageDate:String,
    val recentMessagesCount:Int
)
