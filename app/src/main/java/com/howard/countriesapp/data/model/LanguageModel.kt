package com.howard.countriesapp.data.model


import com.google.gson.annotations.SerializedName

data class LanguageModel(
    @SerializedName("code")
    val code: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("iso639_2")
    val iso6392: String? = null,
    @SerializedName("nativeName")
    val nativeName: String? = null
)