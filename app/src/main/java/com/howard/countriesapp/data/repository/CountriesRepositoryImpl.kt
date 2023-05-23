package com.howard.countriesapp.data.repository

import com.howard.countriesapp.data.model.CountriesModel
import com.howard.countriesapp.data.remote.CountriesApi
import com.howard.countriesapp.data.remote.CountriesNetwork
import retrofit2.Response

class CountriesRepositoryImpl(
    private val countriesApi: CountriesApi = CountriesNetwork.countriesApi
) : CountriesRepository {

    override suspend fun getAllCountries(): Response<CountriesModel> {
        return countriesApi.getAllCountries()
    }
}