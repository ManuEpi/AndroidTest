package com.cryptocurrency.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrencyHistoric(
    @SerializedName("time")
    @Expose
    var time: Double,

    @SerializedName("high")
    @Expose
    var high: Double,

    @SerializedName("low")
    @Expose
    var low: Double,

    @SerializedName("open")
    @Expose
    var open: Double,

    @SerializedName("volumefrom")
    @Expose
    var volumefrom: Double,

    @SerializedName("volumeto")
    @Expose
    var volumeto: Double,

    @SerializedName("close")
    @Expose
    var close: Double,

    @SerializedName("conversionType")
    @Expose
    var conversionType: String,

    @SerializedName("conversionSymbol")
    @Expose
    var conversionSymbol: String
)