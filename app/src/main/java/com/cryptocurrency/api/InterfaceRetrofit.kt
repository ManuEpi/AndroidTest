package com.cryptocurrency.api

import com.cryptocurrency.models.CurrencyHistoric
import com.cryptocurrency.models.topMarket.TopMarketCurrencyResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface InterfaceRetrofit {

    @GET("v2/histoday?api_key=a0aa29cbb5149fbc4dd1e5a390412fc8fd997d9110802c869a65101be40e0aa7")
    fun getHistoric(
        @Query("fsym") fsym: String?,
        @Query("tsym") tsym: String?,
        @Query("limit") limit: Int?
    ): Observable<List<CurrencyHistoric>>


    @GET("top/mktcapfull?api_key=a0aa29cbb5149fbc4dd1e5a390412fc8fd997d9110802c869a65101be40e0aa7")
    fun getTopMarket(
        @Query("tsym") tsym: String?,
        @Query("limit") limit: Int?
    ): Observable<TopMarketCurrencyResponse>
}