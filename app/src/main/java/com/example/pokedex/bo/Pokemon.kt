package com.example.pokedex.bo

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val id: Int,
    val name: String,
    val image: String,
    val sprite: String,
    val stats: PokeStat,
    @Json(name = "apiTypes")
    val types: List<PokeType>

) : Parcelable
