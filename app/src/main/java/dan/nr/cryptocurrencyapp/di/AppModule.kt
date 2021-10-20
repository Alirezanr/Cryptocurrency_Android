package dan.nr.cryptocurrencyapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dan.nr.cryptocurrencyapp.commen.BASE_URL
import dan.nr.cryptocurrencyapp.data.remote.CoinPaprikaApi
import dan.nr.cryptocurrencyapp.data.repository.CoinRepositoryImpl
import dan.nr.cryptocurrencyapp.domain.repository.CoinRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule
{
    @Provides
    @Singleton
    fun provideCoinPapricaApi(): CoinPaprikaApi
    {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository
    {
        return CoinRepositoryImpl(api)
    }
}