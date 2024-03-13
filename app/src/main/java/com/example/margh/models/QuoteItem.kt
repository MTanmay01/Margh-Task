package com.example.margh.models

import androidx.annotation.DrawableRes

data class QuoteItem(
    val imageUrl: String
)

fun dummyQuoteUrls() = listOf(
    QuoteItem("https://daybreakwithray.com/wp-content/uploads/2020/10/right-not-easy.png"),
    QuoteItem("https://daybreakwithray.com/wp-content/uploads/2021/01/be-the-change.png"),
    QuoteItem("https://daybreakwithray.com/wp-content/uploads/2020/10/impossible-until-done.png"),
    QuoteItem("https://daybreakwithray.com/wp-content/uploads/2020/09/make-progress.png"),
    QuoteItem("https://daybreakwithray.com/wp-content/uploads/2020/09/dont-stop.png"),
    QuoteItem("https://daybreakwithray.com/wp-content/uploads/2020/09/be-scared.png"),
    QuoteItem("https://daybreakwithray.com/wp-content/uploads/2020/09/i-get-to.png"),
    QuoteItem("https://daybreakwithray.com/wp-content/uploads/2020/09/no-limit.png")
)
