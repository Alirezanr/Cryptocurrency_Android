package dan.nr.cryptocurrencyapp.presentation.coin_detail

import dan.nr.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(val isLoading: Boolean = false,
                           val coin: CoinDetail? = null,
                           val error: String = "")