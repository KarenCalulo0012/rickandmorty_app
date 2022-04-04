package com.appscals.rickandmortyapp.repository

import com.appscals.rickandmortyapp.network.RetrofitService
import com.appscals.rickandmortyapp.network.response.CharacterResponse

class GetAllCharacterUseCase {

    suspend fun getAllCharacter(characterId: Int): CharacterResponse? {
        val request = RetrofitService.apiClient.getAllCharacter(characterId)

        if (request.failed || !request.isSuccessful) {
            return null
        }

        return request.body
    }
}