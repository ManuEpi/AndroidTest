package com.cryptocurrency.models.topMarket

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Raw(
    @SerializedName("TYPE")
    @Expose
    var type: String,

    @SerializedName("MARKET")
    @Expose
    var market: String,

    @SerializedName("FROMSYMBOL")
    @Expose
    var fromSymbol: String,

    @SerializedName("TOSYMBOL")
    @Expose
    var toSymbol: String,

    @SerializedName("FLAGS")
    @Expose
    var flags: String,

    @SerializedName("PRICE")
    @Expose
    var price: Double,

    @SerializedName("LASTUPDATE")
    @Expose
    var lastUpdate: Double,

    @SerializedName("MEDIAN")
    @Expose
    var median: Double,

    @SerializedName("LASTVOLUME")
    @Expose
    var lastVolume: Double,

    @SerializedName("LASTVOLUMETO")
    @Expose
    var lastVolumeTo: Double,

    @SerializedName("LASTTRADEID")
    @Expose
    var lastTradeId: String,

    @SerializedName("VOLUMEDAY")
    @Expose
    var volumeDay: Double,

    @SerializedName("VOLUMEDAYTO")
    @Expose
    var volumeDayTo: Double,

    @SerializedName("VOLUME24HOUR")
    @Expose
    var volume24Hour: Double,

    @SerializedName("VOLUME24HOURTO")
    @Expose
    var volume24HourTo: Double,

    @SerializedName("OPENDAY")
    @Expose
    var openDay: Double,

    @SerializedName("HIGHDAY")
    @Expose
    var highDay: Double,

    @SerializedName("LOWDAY")
    @Expose
    var lowDay: Double
)