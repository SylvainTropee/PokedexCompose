package com.example.pokedex.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.pokedex.bo.Pokemon
import com.example.pokedex.data.Data


@Composable
fun HeaderPokemonDetail(pokemon: Pokemon){


    

}

@Composable
@Preview
fun PokemonDetailPreview(){
    HeaderPokemonDetail(pokemon = Data.pokemon)
}