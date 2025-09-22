package com.example.currency_kmp.domain

import com.example.currency_kmp.domain.model.Currency
import com.example.currency_kmp.domain.model.RequestState

interface CurrencyApiService {
    suspend fun getLatestExchangeRates(): RequestState<List<Currency>>
}