package dan.nr.cryptocurrencyapp.data.repository

import dan.nr.cryptocurrencyapp.data.remote.CoinPaprikaApi
import dan.nr.cryptocurrencyapp.data.remote.data_transfer_object.CoinDetailDto
import dan.nr.cryptocurrencyapp.data.remote.data_transfer_object.CoinDto
import dan.nr.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
        private val coinPaprikaApi: CoinPaprikaApi) : CoinRepository
{
    override suspend fun getCoins(): List<CoinDto>
    {
        return coinPaprikaApi.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto
    {
        return coinPaprikaApi.getCoinById(coinId)
    }
}