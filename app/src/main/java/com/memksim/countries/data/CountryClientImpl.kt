package com.memksim.countries.data

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.memksim.CountriesQuery
import com.memksim.CountryQuery
import com.memksim.countries.domain.Country
import com.memksim.countries.domain.CountryClient

class CountryClientImpl(
    private val apolloClient: ApolloClient
): CountryClient {

    override suspend fun getCountriesList(): List<Country> {
        val data: ApolloResponse<CountriesQuery.Data> = apolloClient.query(CountriesQuery()).execute()
        return data.data?.countries?.map {
            Country(
                code = it.code,
                name = it.name,
                capital = it.capital.orEmpty()
            )
        } ?: emptyList()
    }

    override suspend fun getCountry(code: String): Country? {
        val data = apolloClient.query(CountryQuery(country_code = code)).execute().data?.country ?: return null
        return Country(
            data.code,
            data.name,
            data.capital.orEmpty()
        )
    }


}