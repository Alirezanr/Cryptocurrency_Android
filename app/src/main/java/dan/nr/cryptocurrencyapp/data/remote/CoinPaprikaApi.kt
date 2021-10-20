package dan.nr.cryptocurrencyapp.data.remote

import dan.nr.cryptocurrencyapp.data.remote.data_transfer_object.CoinDetailDto
import dan.nr.cryptocurrencyapp.data.remote.data_transfer_object.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi
{
    @GET("v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}