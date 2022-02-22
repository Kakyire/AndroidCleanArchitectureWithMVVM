package com.kakyiretechnologies.data.repositories

import com.kakyiretechnologies.data.api.DictionaryService
import com.kakyiretechnologies.data.mappers.DictionaryMapper
import com.kakyiretechnologies.domain.models.DictionaryModel
import com.kakyiretechnologies.domain.repositories.DictionaryRepository
import javax.inject.Inject

/**
 * Created by Daniel Frimpong on February 08, 2022.
 * https://github.com/kakyire
 */

private const val TAG = "DictionaryRepositoryImp"

class DictionaryRepositoryImpl @Inject constructor(
    private val service: DictionaryService,
    private val mapper: DictionaryMapper
) :
    DictionaryRepository {
    override suspend fun getWord(word: String): DictionaryModel {
        val response = service.getWord(word)
        return mapper.dictionaryItemsToDictionaryModel(response)
    }

}