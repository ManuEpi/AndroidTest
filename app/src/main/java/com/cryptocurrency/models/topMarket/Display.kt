package com.cryptocurrency.models.topMarket

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Display(
    @SerializedName("FROMSYMBOL")
    @Expose
    var fromSymbol: String,

    @SerializedName("TOSYMBOL")
    @Expose
    var toSymbol: String,

    @SerializedName("MARKET")
    @Expose
    var market: String,

    @SerializedName("PRICE")
    @Expose
    var price: String,

    @SerializedName("LASTUPDATE")
    @Expose
    var lastUpdate: String,

    @SerializedName("LASTVOLUME")
    @Expose
    var lastVolume: String,

    @SerializedName("LASTVOLUMETO")
    @Expose
    var lastVolumeTo: String,

    @SerializedName("LASTTRADEID")
    @Expose
    var lastTradeId: String,

    @SerializedName("VOLUMEDAY")
    @Expose
    var volumeDay: String,

    @SerializedName("VOLUMEDAYTO")
    @Expose
    var volumeDayTo: String,

    @SerializedName("VOLUME24HOUR")
    @Expose
    var volume24Hour: String,

    @SerializedName("VOLUME24HOURTO")
    @Expose
    var volume24HourTo: String,

    @SerializedName("OPENDAY")
    @Expose
    var openDay: String,

    @SerializedName("HIGHDAY")
    @Expose
    var highDay: String,

    @SerializedName("LOWDAY")
    @Expose
    var lowDay: String
)