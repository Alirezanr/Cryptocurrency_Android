package dan.nr.cryptocurrencyapp.domain.use_case.get_coins

import dan.nr.cryptocurrencyapp.commen.Resource
import dan.nr.cryptocurrencyapp.data.remote.data_transfer_object.toCoin
import dan.nr.cryptocurrencyapp.domain.model.Coin
import dan.nr.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository)
{
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try
        {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins()
            emit(Resource.Success<List<Coin>>(coins.map { it.toCoin() }))
        } catch (e: HttpException)
        {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException)
        {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "Check your internet connection"))
        }
    }
}