package com.example.eni_shop.service

import com.example.pokedex.bo.PokeType
import com.example.pokedex.bo.Pokemon
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    companion object {
        val BASE_URL = "https://pokebuildapi.fr/api/v1/"

        //convertisseur intégré dans retrofit,
        // permet de transformer le JSON en objet et inversement
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        //librairie qui permet de lancer nos appels API, en créant une interface
        val retrofit = Retrofit.Builder()
            //ajout du converter Json
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }

    //ajout des méthodes d'appel de l'api, BASE_URL + random
    @GET("pokemon")
    suspend fun getPokemons(): List<Pokemon>

    @GET("pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id: Long): Pokemon

   @GET("types")
   suspend fun getAllTypes() : List<PokeType>


    object PokemonApi {
        val retrofitService: PokemonService by lazy { retrofit.create(PokemonService::class.java) }
    }

}