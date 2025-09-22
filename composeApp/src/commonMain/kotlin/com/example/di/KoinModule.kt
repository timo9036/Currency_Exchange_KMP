package com.example.di

import com.russhwolf.settings.Settings
import com.example.currency_kmp.data.local.MongoImpl
import com.example.currency_kmp.data.local.PreferencesImpl
import com.example.currency_kmp.data.remote.api.CurrencyApiServiceImpl
import com.example.currency_kmp.domain.CurrencyApiService
import com.example.currency_kmp.domain.MongoRepository
import com.example.currency_kmp.domain.PreferencesRepository
import org.koin.core.context.startKoin
import org.koin.dsl.module
import com.example.currency_kmp.presentation.screen.HomeViewModel

val appModule = module {
    single { Settings() }
    single<MongoRepository> { MongoImpl() }
    single<PreferencesRepository> { PreferencesImpl(settings = get()) }
    single<CurrencyApiService> { CurrencyApiServiceImpl(preferences = get()) }
    factory {
        HomeViewModel(
            preferences = get(),
            mongoDb = get(),
            api = get()
        )
    }
}

fun initializeKoin() {
    startKoin {
        modules(appModule)
    }
}