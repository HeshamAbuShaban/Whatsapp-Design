package dev.training.whatsapp_design.data.local.dummy

import android.graphics.Bitmap

data class Call(
    val img: Bitmap?,
    val name: String,
    val condition: Int,
    val type: Int = 0,
    val times: Int,
    val date:String,
)
