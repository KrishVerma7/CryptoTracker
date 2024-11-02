package com.plcoding.cryptotracker.crypto.presentation.models

import androidx.annotation.DrawableRes
import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.core.presentation.util.getDrawableIdForCoin
import java.text.NumberFormat
import java.util.Locale

/***
 * model data class for Coin
 */
data class CoinUi(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUsd: DisplayableNumber,
    val priceUsd: DisplayableNumber,
    val changePercent24Hr: DisplayableNumber,
    @DrawableRes val iconRes: Int
)

/***
 * this data class is to convert the price, marketCap and changePercent
 * into formatted form, like proper commas, decimal, round-off, icons etc. of Coin UI
 */
data class DisplayableNumber(
    val value: Double,
    val formatted: String
)

fun Coin.toCoinUi(): CoinUi {
    return CoinUi(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        priceUsd = priceUsd.toDisplyableNumber(),
        marketCapUsd = marketCapUsd.toDisplyableNumber(),
        changePercent24Hr = changePercent24Hr.toDisplyableNumber(),
        iconRes = getDrawableIdForCoin(symbol)
    )
}

/**
 * Format maximum and minimum decimal places
 */
fun Double.toDisplyableNumber(): DisplayableNumber {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }
    return DisplayableNumber(
        value = this,
        formatted = formatter.format(this)
    )
}