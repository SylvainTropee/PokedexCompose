package com.example.pokedex.bo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokeType(
    val name : String,
    val image : String
) :Parcelable
