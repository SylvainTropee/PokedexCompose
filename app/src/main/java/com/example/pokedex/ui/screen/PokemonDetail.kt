package com.example.pokedex.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.pokedex.bo.PokeStat
import com.example.pokedex.bo.PokeType
import com.example.pokedex.bo.Pokemon
import com.example.pokedex.data.Data
import com.example.pokedex.vm.PokemonViewModel


@Composable
fun PokemonDetailScreen(pokemon: Pokemon) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = pokemon.name,
            fontSize = 60.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        AsyncImage(
            model = pokemon.image,
            contentDescription = pokemon.name,
            modifier = Modifier.size(180.dp)
        )
        PokemonDetailStat(stat = pokemon.stats)
        PokemonDetailTypes(types = pokemon.types)
        PokemonDetailEvolution(
            evolution = pokemon.evolution,
            preEvolution = pokemon.preEvolution,
            pokemon.image
        )
    }

}

@Composable
fun PokemonDetailEvolution(
    evolution: List<Pokemon>,
    preEvolution: Pokemon?,
    image: String,
    pokemonViewModel: PokemonViewModel = viewModel()
) {
    PokemonDetailMenuHeader(title = "Evolution", borderColor = MaterialTheme.colorScheme.tertiary) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            if (preEvolution != null) {
                Column(verticalArrangement = Arrangement.Center) {
                    Text(text = "Ancêtre")
                    val pokemon by pokemonViewModel.getPokemonById(preEvolution.id)
                    Column(verticalArrangement = Arrangement.Center) {
                        AsyncImage(
                            model = pokemon?.image, contentDescription = null,
                            modifier = Modifier.size(60.dp)
                        )
                        Text(text = preEvolution.name)
                    }

                }
                Spacer(
                    Modifier
                        .size(4.dp, 36.dp)
                        .background(color = MaterialTheme.colorScheme.tertiary)
                )
            }
            if (evolution.isNotEmpty()) {
                Column(verticalArrangement = Arrangement.Center) {
                    Text(text = "Evolution")
                    evolution.forEach {
                        val pokemon by pokemonViewModel.getPokemonById(it.id)
                        Column(verticalArrangement = Arrangement.Center) {
                            AsyncImage(
                                model = pokemon?.image, contentDescription = null,
                                modifier = Modifier.size(60.dp)
                            )
                            Text(text = it.name)
                        }

                    }
                }
            }
        }

    }
}

@Composable
fun PokemonDetailTypes(types: List<PokeType>) {
    PokemonDetailMenuHeader(
        title = "Types",
        borderColor = MaterialTheme.colorScheme.secondary
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            types.forEach {
                Column(verticalArrangement = Arrangement.Center) {
                    AsyncImage(
                        model = it.image,
                        contentDescription = it.name,
                        modifier = Modifier.size(40.dp)
                    )
                    Text(text = it.name)
                }
            }
        }
    }
}

@Composable
fun PokemonDetailStat(stat: PokeStat) {

    PokemonDetailMenuHeader(
        title = "Statistiques",
        borderColor = MaterialTheme.colorScheme.primary
    ) {
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = "HP : ${stat.hp}")
                Text(text = "Attaque : ${stat.attack}")
                Text(text = "Attaque spéciale : ${stat.specialAttack}")

            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = "Vitesse : ${stat.speed}")
                Text(text = "Défense : ${stat.defense}")
                Text(text = "Défense spéciale : ${stat.specialDefense}")
            }
        }
    }
}


@Composable
fun PokemonDetailMenuHeader(
    title: String,
    borderColor: Color,
    content: @Composable () -> Unit
) {

    var isMenuClicked by rememberSaveable {
        mutableStateOf(false)
    }

    val menuIcon = if (isMenuClicked) {
        Icons.Default.ArrowDropUp
    } else {
        Icons.Default.ArrowDropDown
    }

    Surface(
        shape = MaterialTheme.shapes.small,
        border = BorderStroke(2.dp, borderColor),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    isMenuClicked = !isMenuClicked
                }
            ) {
                Icon(
                    imageVector = menuIcon, contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Text(
                    text = title,
                    fontSize = 20.sp
                )
            }
            if (isMenuClicked) {
                content()
            }
        }
    }
}

@Composable
@Preview
fun PokemonDetailPreview() {
    PokemonDetailScreen(pokemon = Data.pokemon)
}