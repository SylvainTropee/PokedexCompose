package com.example.pokedex.bo

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokeStat(
    @Json(name = "HP")
    val hp  : Int,
    val attack  : Int,
    val defense  : Int,
    @Json(name = "special_attack")
    val specialAttack  : Int,
    @Json(name = "special_defense")
    val specialDefense : Int,
    val speed : Int
): Parcelable