package dan.nr.cryptocurrencyapp.domain.use_case.get_coin

import dan.nr.cryptocurrencyapp.commen.Resource
import dan.nr.cryptocurrencyapp.data.remote.data_transfer_object.toCoinDetail
import dan.nr.cryptocurrencyapp.domain.model.CoinDetail
import dan.nr.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository)
{
    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try
        {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId)
            emit(Resource.Success<CoinDetail>(coin.toCoinDetail()))
        } catch (e: HttpException)
        {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException)
        {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "Check your internet connection"))
        }
    }
}