package com.kakyiretechnologies.domain.repositories

import com.kakyiretechnologies.domain.models.DictionaryModel

/**
 * Created by Daniel Frimpong on February 08, 2022.
 * https://github.com/kakyire
 */
interface DictionaryRepository {
    suspend fun getWord(word: String): DictionaryModel
}