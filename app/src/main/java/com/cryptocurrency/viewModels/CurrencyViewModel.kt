package com.cryptocurrency.viewModels

import android.app.ActivityGroup
import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.cryptocurrency.models.CurrencyHistoric
import com.cryptocurrency.models.topMarket.TopMarketCurrencyResponse
import com.cryptocurrency.repositories.CurrencyRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.ObservableSource
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
class CurrencyViewModel
@ViewModelInject
constructor(
    private val currencyRepository: CurrencyRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val currencyHistoric: MutableLiveData<List<CurrencyHistoric>> =
        MutableLiveData<List<CurrencyHistoric>>()
    val topMarketCurrencies: MutableLiveData<TopMarketCurrencyResponse> =
        MutableLiveData<TopMarketCurrencyResponse>()

    fun getTopMarketCurrencies(tsym: String?, limit: Int?) {
        if (tsym == null || limit == null)
            return

        currencyRepository.getTopMarket(tsym, limit)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ newCurrencies ->
                topMarketCurrencies.value = newCurrencies
            }, { throwable ->
                Log.e("Error", throwable.localizedMessage)
            })
    }

    fun getCurrencyHistoric(fsym: String?, tsym: String?, limit: Int?) {
        if (fsym == null || tsym == null || limit == null)
            return

        currencyRepository.getCurrencyHistoric(fsym, tsym, limit)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { newHistoric ->
                currencyHistoric.value = newHistoric
            }
    }
}
