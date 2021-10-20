package dan.nr.cryptocurrencyapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dan.nr.cryptocurrencyapp.commen.PARAM_COIN_ID
import dan.nr.cryptocurrencyapp.presentation.coin_detail.CoinDetailScreen
import dan.nr.cryptocurrencyapp.presentation.coin_list.CoinListScreen
import dan.nr.cryptocurrencyapp.presentation.ui.theme.CryptocurrencyAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                            startDestination = Screen.CoinListScreen.rout) {
                        composable(route = Screen.CoinListScreen.rout) {
                            CoinListScreen(navController)
                        }
                        composable(route = Screen.CoinDetailScreen.rout + "/{$PARAM_COIN_ID}") {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}