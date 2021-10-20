package dan.nr.cryptocurrencyapp.domain.repository

import dan.nr.cryptocurrencyapp.data.remote.data_transfer_object.CoinDetailDto
import dan.nr.cryptocurrencyapp.data.remote.data_transfer_object.CoinDto

interface CoinRepository
{
    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinById(coinId:String):CoinDetailDto
}