package com.example.pokedex.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.pokedex.bo.PokeType
import com.example.pokedex.bo.Pokemon
import com.example.pokedex.data.Data
import com.example.pokedex.ui.common.LoadingScreen
import com.example.pokedex.vm.PokemonViewModel


private const val TAG = "PokemonList"

@Composable
fun PokemonListScreen(
    modifier: Modifier = Modifier,
    pokemonVM: PokemonViewModel = viewModel()
) {
    val pokemons by pokemonVM.pokemons
    val isLoading by pokemonVM.isLoading
    val types by pokemonVM.types

    pokemonVM.getAllPokemons()
    pokemonVM.getAllTypes()

    if (!isLoading) {
        LoadingScreen()
    } else {
        PokemonList(
            pokemons = pokemons,
            types = types
        )
    }
}

@Composable
fun PokemonList(
    modifier: Modifier = Modifier,
    pokemons: List<Pokemon>,
    types: List<PokeType>
) {
    var researchPokemon by rememberSaveable {
        mutableStateOf(pokemons)
    }

    Column {
        SearchBar() {
            researchPokemon = pokemons.filter { pokemon ->
                pokemon.name.contains(it, ignoreCase = true)
            }
        }
        PokemonTypeRow(types = types) {
            researchPokemon = pokemons.filter { pokemon ->
                pokemon.types.any { pokeType ->
                    pokeType.name == it
                }
            }
        }
        LazyColumn {
            items(researchPokemon) {
                PokemonItem(pokemon = it)
            }
        }
    }
}


@Composable
fun PokemonTypeRow(
    types: List<PokeType>,
    typeEvent: (name: String) -> Unit
) {

    LazyRow() {
        items(types) {
            AsyncImage(
                model = it.image, contentDescription = it.name,
                modifier = Modifier.clickable {
                    typeEvent(it.name)
                }.padding(4.dp)
            )
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    var searchText by remember {
        mutableStateOf("")
    }

    TextField(
        value = searchText,
        onValueChange = {
            searchText = it
            onValueChange(it)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text(text = "Pokemon...")
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .padding(4.dp)
    )
}

@Composable
fun PokemonItem(
    modifier: Modifier = Modifier,
    pokemon: Pokemon
) {

    Surface(
        shadowElevation = 8.dp,
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.primary),
        modifier = modifier.padding(4.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = pokemon.image,
                contentDescription = pokemon.name,
                modifier = Modifier
                    .size(65.dp)
                    .border(1.5.dp, MaterialTheme.colorScheme.secondary, RoundedCornerShape(20.dp))
                    .padding(4.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = pokemon.name,
                    fontSize = 30.sp,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    pokemon.types.forEach { type ->
                        AsyncImage(
                            model = type.image,
                            contentDescription = type.name,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }

            }

        }
    }
}

@Composable
@Preview
fun PokemonListPreview() {
    PokemonItem(pokemon = Data.pokemon)

}