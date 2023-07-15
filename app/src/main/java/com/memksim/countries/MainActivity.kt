package com.memksim.countries

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo3.ApolloClient
import com.memksim.countries.data.CountryClientImpl
import com.memksim.countries.ui.theme.CountriesTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val apolloClient = ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
        val countryClient = CountryClientImpl(apolloClient = apolloClient)
        lifecycleScope.launch {
            /*countryClient.getCountriesList().forEach {
                Log.d("M_TEST", "onCreate: $it")
            }*/
            Log.d("M_TEST", "onCreate: ${countryClient.getCountry("RU")}")
        }
        setContent {
            CountriesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text(text = "hiii")
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CountriesTheme {

    }
}