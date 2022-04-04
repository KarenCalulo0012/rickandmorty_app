package com.appscals.rickandmortyapp.network

import com.appscals.rickandmortyapp.network.response.CharacterResponse
import retrofit2.Response

class ApiClient(private val apiInterface: ApiInterface) {

    private inline fun <T> customAPICall(apiCall: () -> Response<T>): CustomResponse<T> {
        return try {
            CustomResponse.success(apiCall.invoke())
        } catch (e: Exception) {
            CustomResponse.failure(e)
        }
    }

    suspend fun getAllCharacter(characterId: Int): CustomResponse<CharacterResponse> {
        return customAPICall { apiInterface.getAllCharacter(characterId) }
    }

}