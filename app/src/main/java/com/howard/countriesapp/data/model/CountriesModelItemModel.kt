package com.howard.countriesapp.data.model


import com.google.gson.annotations.SerializedName

data class CountriesModelItemModel(
    @SerializedName("capital")
    val capital: String? = null,
    @SerializedName("code")
    val code: String? = null,
    @SerializedName("currency")
    val currency: CurrencyModel? = null,
    @SerializedName("flag")
    val flag: String? = null,
    @SerializedName("language")
    val language: LanguageModel? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("region")
    val region: String? = null,
    @SerializedName("demonym")
    val demonym: String? = null
)