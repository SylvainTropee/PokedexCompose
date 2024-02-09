package com.example.pokedex.data

import com.example.pokedex.bo.PokeStat
import com.example.pokedex.bo.PokeType
import com.example.pokedex.bo.Pokemon

object Data {

    val pokemon = Pokemon(
        id = 1,
        name = "Bulbasaur",
        image = "bulbasaur.png",
        sprite = "bulbasaur_sprite.png",
        stats = PokeStat(
            hp = 45,
            attack = 49,
            defense = 49,
            specialAttack = 65,
            specialDefense = 65,
            speed = 45
        ),
        types = listOf(
            PokeType(name = "grass", image = "grass.png"),
            PokeType(name = "poison", image = "poison.png")
        )
    )
}