package dan.nr.cryptocurrencyapp.presentation.coin_list

import dan.nr.cryptocurrencyapp.domain.model.Coin

data class CoinListState(val isLoading: Boolean = false,
                         val coinsList: List<Coin> = emptyList(),
                         val error: String = "")