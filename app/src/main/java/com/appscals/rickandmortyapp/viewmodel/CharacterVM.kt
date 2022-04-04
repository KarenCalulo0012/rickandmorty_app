package com.appscals.rickandmortyapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appscals.rickandmortyapp.network.response.CharacterResponse
import com.appscals.rickandmortyapp.repository.GetAllCharacterUseCase
import kotlinx.coroutines.launch

class CharacterVM: ViewModel() {
    private val characterRepo = GetAllCharacterUseCase()

    private val _characterData = MutableLiveData<CharacterResponse?>()
    val characterLiveData : LiveData<CharacterResponse?> = _characterData

    fun getAllCharacters(characterId: Int) {
        viewModelScope.launch {
            val response = characterRepo.getAllCharacter(characterId)
            _characterData.postValue(response)
        }
    }
}