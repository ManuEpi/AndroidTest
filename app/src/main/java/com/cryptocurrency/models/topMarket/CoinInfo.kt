package com.cryptocurrency.models.topMarket

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfo(
    @SerializedName("Id")
    @Expose
    var id: String,

    @SerializedName("Name")
    @Expose
    var name: String,

    @SerializedName("FullName")
    @Expose
    var fullName: String,

    @SerializedName("Internal")
    @Expose
    var internal: String,

    @SerializedName("ImageUrl")
    @Expose
    var imageUrl: String,

    @SerializedName("Url")
    @Expose
    var url: String
)