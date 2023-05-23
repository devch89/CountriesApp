package com.howard.countriesapp.data.repository

import com.howard.countriesapp.data.model.CountriesModel
import retrofit2.Response

interface CountriesRepository {
    suspend fun getAllCountries(): Response<CountriesModel>
}