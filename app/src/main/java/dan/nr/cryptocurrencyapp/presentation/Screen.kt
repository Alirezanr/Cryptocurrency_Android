package dan.nr.cryptocurrencyapp.presentation

sealed class Screen(val rout:String)
{
    object CoinListScreen: Screen("coin_list_screen")
    object CoinDetailScreen: Screen("coin_detail_screen")

}