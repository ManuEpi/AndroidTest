package com.cryptocurrency.repositories

import com.cryptocurrency.api.InterfaceRetrofit
import com.cryptocurrency.models.CurrencyHistoric
import com.cryptocurrency.models.topMarket.TopMarketCurrencyResponse
import io.reactivex.rxjava3.core.Observable

class CurrencyRepository
constructor(
    private val interfaceRetrofit: InterfaceRetrofit
) {
    fun getCurrencyHistoric(
        fsym: String,
        tsym: String,
        limit: Int
    ): Observable<List<CurrencyHistoric>> {
        return interfaceRetrofit.getHistoric(fsym, tsym, limit)
    }

    fun getTopMarket(
        tsym: String,
        limit: Int
    ): Observable<TopMarketCurrencyResponse> {
        return interfaceRetrofit.getTopMarket(tsym, limit)
    }
}