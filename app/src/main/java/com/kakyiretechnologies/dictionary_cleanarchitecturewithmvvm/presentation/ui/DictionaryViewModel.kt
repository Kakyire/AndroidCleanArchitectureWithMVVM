package com.kakyiretechnologies.dictionary_cleanarchitecturewithmvvm.presentation.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kakyiretechnologies.domain.common.Resource
import com.kakyiretechnologies.domain.models.DictionaryModel
import com.kakyiretechnologies.domain.repositories.DictionaryRepository
import com.kakyiretechnologies.domain.useCases.GetWordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Daniel Frimpong on February 08, 2022.
 * https://github.com/kakyire
 */
private const val TAG = "DictionaryViewModel"

@HiltViewModel
class DictionaryViewModel @Inject constructor(
    private val repository: DictionaryRepository,
    private val wordUseCase: GetWordUseCase
) :
    ViewModel() {

    private val _wordMeaning =
        MutableLiveData<Resource<DictionaryModel>>()
    val wordMeaning: LiveData<Resource<DictionaryModel>> = _wordMeaning


    fun wordUseCaseMeaning(word: String) = viewModelScope.launch {

        wordUseCase.invoke(word).onStart {
            _wordMeaning.value = Resource.Loading()
        }
            .catch {
                Log.d(TAG, "wordUseCaseMeaning: ${it.printStackTrace()}")
                _wordMeaning.value = Resource.Error(it.localizedMessage)
            }
            .collect {
                Log.d(TAG, "wordUseCaseMeaning: $it")
                _wordMeaning.value = Resource.Success(it)
            }


    }

    fun getMeaning(word: String) = viewModelScope.launch {
        /*repository.getWord(word)
            .onStart {
                _wordMeaning.value = Resource.Loading()
            }
            .catch {
                Log.d(TAG, "error: ${it.localizedMessage}")
                _wordMeaning.value = Resource.Error(it.localizedMessage)
            }.collect {
                Log.d(TAG, "getMeaning: $it")
                _wordMeaning.value = Resource.Success(it)
            }*/
    }
}