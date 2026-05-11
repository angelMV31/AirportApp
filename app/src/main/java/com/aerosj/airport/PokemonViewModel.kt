package com.aerosj.airport

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {

    private val _pokemonList = MutableStateFlow<List<PokemonBasic>>(emptyList())
    val pokemonList: StateFlow<List<PokemonBasic>> = _pokemonList

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getPokemonList(limit = 10, offset = 0)
                _pokemonList.value = response.results
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}