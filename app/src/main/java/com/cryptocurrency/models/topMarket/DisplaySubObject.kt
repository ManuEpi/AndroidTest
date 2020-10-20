package com.cryptocurrency.models.topMarket

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DisplaySubObject(
    @SerializedName("EUR")
    @Expose
    var eur: Display,
)