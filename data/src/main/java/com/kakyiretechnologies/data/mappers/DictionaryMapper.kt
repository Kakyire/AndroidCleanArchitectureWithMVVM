package com.kakyiretechnologies.data.mappers

import com.kakyiretechnologies.data.models.DictionaryResponse
import com.kakyiretechnologies.domain.models.DictionaryModel
import javax.inject.Inject

/**
 * Created by Daniel Frimpong on February 08, 2022.
 * https://github.com/kakyire
 */
class DictionaryMapper @Inject constructor() {

    fun dictionaryItemsToDictionaryModel(dictionaryResponse: DictionaryResponse): DictionaryModel {
        var dictionaryModel = DictionaryModel()
        dictionaryResponse.map {

            dictionaryModel = DictionaryModel(phonetic = it.phonetic, origin = it.origin)
        }
        return dictionaryModel
    }
}