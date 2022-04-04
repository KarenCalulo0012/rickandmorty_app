package com.appscals.rickandmortyapp.network

import com.appscals.rickandmortyapp.network.response.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("character/{character_id}")
    suspend fun getAllCharacter(@Path("character_id") characterId: Int): Response<CharacterResponse>
}