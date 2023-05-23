package com.howard.countriesapp.data.remote

import com.howard.countriesapp.data.model.CountriesModel
import retrofit2.Response
import retrofit2.http.GET

interface CountriesApi {

    @GET(CountriesApiReference.END_POINT)
    suspend fun getAllCountries(): Response<CountriesModel>
}