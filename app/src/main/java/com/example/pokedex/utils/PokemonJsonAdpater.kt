package com.example.pokedex.utils

import com.example.pokedex.bo.PokeStat
import com.example.pokedex.bo.PokeType
import com.example.pokedex.bo.Pokemon
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson
import com.squareup.moshi.Types

class PokemonAdapter {
//    @FromJson
//    fun fromJson(jsonReader: JsonReader, options: JsonAdapter.Factory): Pokemon {
//        var id = 0
//        var name = ""
//        var image = ""
//        var sprite = ""
//        var stats = PokeStat(0, 0, 0, 0, 0, 0)
//        var types = emptyList<PokeType>()
//        var generation = 0
//        var evolution = emptyList<Pokemon>()
//        var preEvolution: Pokemon? = null
//
//        jsonReader.beginObject()
//        while (jsonReader.hasNext()) {
//            when (jsonReader.nextName()) {
//                "id", "pokedexId" -> id = jsonReader.nextInt()
//                "name" -> name = jsonReader.nextString()
//                "image" -> image = jsonReader.nextString()
//                "sprite" -> sprite = jsonReader.nextString()
//                "stats" -> stats = (options.create(PokeStat::class.java).fromJson(jsonReader) ?: PokeStat(0, 0, 0, 0, 0, 0)) as PokeStat
//                "apiTypes" -> types = options.create(Types.newParameterizedType(List::class.java, PokeType::class.java)).fromJson(jsonReader) ?: emptyList()
//                "apiGeneration" -> generation = jsonReader.nextInt()
//                "apiEvolutions" -> evolution = options.create(Types.newParameterizedType(List::class.java, Pokemon::class.java)).fromJson(jsonReader) ?: emptyList()
//                "apiPreEvolution" -> preEvolution = options.create(Pokemon::class.java).fromJson(jsonReader)
//                else -> jsonReader.skipValue()
//            }
//        }
//        jsonReader.endObject()
//
//        return Pokemon(id, name, image, sprite, stats, types, generation, evolution, preEvolution)
//    }
//
//    @ToJson
//    fun toJson(jsonWriter: JsonWriter, value: Pokemon, options: JsonAdapter.Factory) {
//        // You can implement this method if you need to serialize Pokemon objects
//        // Normally, Moshi's default serialization should work fine
//        throw UnsupportedOperationException("Not implemented")
//    }
//}
//
//class PokeStatAdapter {
//    @FromJson
//    fun fromJson(jsonReader: JsonReader): PokeStat {
//        var hp = 0
//        var attack = 0
//        var defense = 0
//        var specialAttack = 0
//        var specialDefense = 0
//        var speed = 0
//
//        jsonReader.beginObject()
//        while (jsonReader.hasNext()) {
//            when (jsonReader.nextName()) {
//                "HP" -> hp = jsonReader.nextInt()
//                "attack" -> attack = jsonReader.nextInt()
//                "defense" -> defense = jsonReader.nextInt()
//                "special_attack" -> specialAttack = jsonReader.nextInt()
//                "special_defense" -> specialDefense = jsonReader.nextInt()
//                "speed" -> speed = jsonReader.nextInt()
//                else -> jsonReader.skipValue()
//            }
//        }
//        jsonReader.endObject()
//
//        return PokeStat(hp, attack, defense, specialAttack, specialDefense, speed)
//    }
//
//    @ToJson
//    fun toJson(jsonWriter: JsonWriter, value: PokeStat) {
//        // You can implement this method if you need to serialize PokeStat objects
//        // Normally, Moshi's default serialization should work fine
//        throw UnsupportedOperationException("Not implemented")
//    }
//}
//
//class PokeTypeAdapter {
//    @FromJson
//    fun fromJson(jsonReader: JsonReader): PokeType {
//        var name = ""
//        var image = ""
//
//        jsonReader.beginObject()
//        while (jsonReader.hasNext()) {
//            when (jsonReader.nextName()) {
//                "name" -> name = jsonReader.nextString()
//                "image" -> image = jsonReader.nextString()
//                else -> jsonReader.skipValue()
//            }
//        }
//        jsonReader.endObject()
//
//        return PokeType(name, image)
//    }
//
//    @ToJson
//    fun toJson(jsonWriter: JsonWriter, value: PokeType) {
//        // You can implement this method if you need to serialize PokeType objects
//        // Normally, Moshi's default serialization should work fine
//        throw UnsupportedOperationException("Not implemented")
//    }
}

