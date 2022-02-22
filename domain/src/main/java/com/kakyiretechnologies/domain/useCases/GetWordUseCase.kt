package com.kakyiretechnologies.domain.useCases

import com.kakyiretechnologies.domain.repositories.DictionaryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by Daniel Frimpong on February 08, 2022.
 * https://github.com/kakyire
 */
class GetWordUseCase @Inject constructor(private val dictionaryRepository: DictionaryRepository) {
    suspend operator fun invoke(word: String) = flow {

        emit(dictionaryRepository.getWord(word))
    }.flowOn(Dispatchers.IO)
}