package com.cryptocurrency.models.topMarket

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TopMarketCurrencyResponse(
    @SerializedName("Message")
    @Expose
    var message: String,

    @SerializedName("Type")
    @Expose
    var type: Int,

    @SerializedName("Data")
    @Expose
    var currencies: Array<Currency>,
)