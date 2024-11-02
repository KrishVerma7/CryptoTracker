package com.plcoding.cryptotracker.core.domain

import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.core.domain.util.Result
import com.plcoding.cryptotracker.crypto.domain.Coin

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}