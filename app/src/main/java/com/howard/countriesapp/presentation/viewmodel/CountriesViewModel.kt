package com.howard.countriesapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.howard.countriesapp.data.model.CountriesModel
import com.howard.countriesapp.data.repository.CountriesRepository
import com.howard.countriesapp.data.repository.CountriesRepositoryImpl
import com.howard.countriesapp.util.UIState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountriesViewModel(
    private val countriesRepository: CountriesRepository = CountriesRepositoryImpl(),
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _result = MutableLiveData<UIState<CountriesModel>>()
    val result: LiveData<UIState<CountriesModel>> get() = _result

    init {
        getAllCountries()
    }

    private fun getAllCountries() {
        viewModelScope.launch(ioDispatcher) {
            _result.postValue(UIState.Loading)
            try {
                val response = countriesRepository.getAllCountries()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _result.postValue(UIState.Success(it))
                    } ?: throw Exception("Response is null")
                } else {
                    throw Exception(response.errorBody()?.string())
                }
            } catch (e: Exception) {
                _result.postValue(UIState.Error(e))
            }

        }
    }
}