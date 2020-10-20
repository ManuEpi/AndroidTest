package com.cryptocurrency.models.topMarket

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("CoinInfo")
    @Expose
    var coinInfo: CoinInfo,

    @SerializedName("RAW")
    @Expose
    var raw: RawSubObject,

    @SerializedName("DISPLAY")
    @Expose
    var display: DisplaySubObject
)