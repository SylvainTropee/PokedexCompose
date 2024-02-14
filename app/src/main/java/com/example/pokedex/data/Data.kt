package com.example.pokedex.data

import com.example.pokedex.bo.PokeStat
import com.example.pokedex.bo.PokeType
import com.example.pokedex.bo.Pokemon

object Data {

    val pokemon = Pokemon(
        id = 1,
        name = "Bulbasaur",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
        sprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
        stats = PokeStat(
            hp = 45,
            attack = 49,
            defense = 49,
            specialAttack = 65,
            specialDefense = 65,
            speed = 45
        ),
        types = listOf(
            PokeType(
                name = "Poison",
                image = "https://static.wikia.nocookie.net/pokemongo/images/0/05/Poison.png"
            ),
            PokeType(
                name = "Plante",
                image = "https://static.wikia.nocookie.net/pokemongo/images/c/c5/Grass.png"
            )
        ),
        generation = 1,
        evolution = listOf(
            Pokemon(
                id = 2,
                name = "Bulbasaur",
                image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
                sprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
                stats = PokeStat(
                    hp = 45,
                    attack = 49,
                    defense = 49,
                    specialAttack = 65,
                    specialDefense = 65,
                    speed = 45
                ),
                types = listOf(
                    PokeType(
                        name = "Poison",
                        image = "https://static.wikia.nocookie.net/pokemongo/images/0/05/Poison.png"
                    ),
                    PokeType(
                        name = "Plante",
                        image = "https://static.wikia.nocookie.net/pokemongo/images/c/c5/Grass.png"
                    )
                ),
                generation = 1,
                evolution = emptyList(),
                preEvolution = null
            )
        ),
        preEvolution =
        Pokemon(
            id = 2,
            name = "Bulbasaur",
            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
            sprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
            stats = PokeStat(
                hp = 45,
                attack = 49,
                defense = 49,
                specialAttack = 65,
                specialDefense = 65,
                speed = 45
            ),
            types = listOf(
                PokeType(
                    name = "Poison",
                    image = "https://static.wikia.nocookie.net/pokemongo/images/0/05/Poison.png"
                ),
                PokeType(
                    name = "Plante",
                    image = "https://static.wikia.nocookie.net/pokemongo/images/c/c5/Grass.png"
                )
            ),
            generation = 1,
            evolution = emptyList(),
            preEvolution = null
        )
    )
}