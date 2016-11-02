package com.github.kttinunf.forge.function

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Kittinun Vantasin on 8/26/15.
 */

//date
fun toDate(style: String = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"): (String) -> Date = {
    val formatter = SimpleDateFormat(style, Locale.getDefault())
    formatter.parse(it)
}
