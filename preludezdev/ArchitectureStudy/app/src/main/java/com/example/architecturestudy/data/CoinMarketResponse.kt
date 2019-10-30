package com.example.architecturestudy.data

import com.google.gson.annotations.SerializedName

data class CoinMarketResponse(
    @SerializedName("market")
    val market: String = "",
    @SerializedName("korean_name")
    val koreanName: String = "",
    @SerializedName("english_name")
    val englishName: String = ""
)