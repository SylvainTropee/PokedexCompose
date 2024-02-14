package com.example.pokedex.vm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eni_shop.service.PokemonService
import com.example.pokedex.bo.PokeType
import com.example.pokedex.bo.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {

    var pokemons = mutableStateOf<List<Pokemon>>(emptyList())
    var isLoading = mutableStateOf(false)
    var types = mutableStateOf<List<PokeType>>(emptyList())
    //var pokemon = mutableStateOf<Pokemon?>(null)

    fun getAllPokemons(){
        viewModelScope.launch(Dispatchers.IO) {
            pokemons.value = PokemonService.PokemonApi.retrofitService.getPokemons()
            isLoading.value = true
        }
    }

    fun getAllTypes(){
        viewModelScope.launch(Dispatchers.IO) {
           types.value = PokemonService.PokemonApi.retrofitService.getAllTypes()
        }
    }

    fun getPokemonById(id : Int): MutableState<Pokemon?> {
        var pokemon = mutableStateOf<Pokemon?>(null)
        viewModelScope.launch(Dispatchers.IO) {
            pokemon.value = PokemonService.PokemonApi.retrofitService.getPokemonById(id)
        }
        return pokemon
    }






}