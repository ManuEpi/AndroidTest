package com.cryptocurrency.modules

import com.cryptocurrency.api.InterfaceRetrofit
import com.cryptocurrency.repositories.CurrencyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCurrencyRepository(
        interfaceRetrofit: InterfaceRetrofit
    ): CurrencyRepository {
        return CurrencyRepository(interfaceRetrofit)
    }
}
