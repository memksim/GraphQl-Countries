package com.memksim.countries.domain

interface CountryClient {

    suspend fun getCountriesList(): List<Country>

    suspend fun getCountry(code: String): Country?


}