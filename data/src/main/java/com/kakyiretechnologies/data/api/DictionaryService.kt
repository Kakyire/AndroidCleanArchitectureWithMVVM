package com.kakyiretechnologies.data.api

import com.kakyiretechnologies.data.models.DictionaryResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Daniel Frimpong on February 08, 2022.
 * https://github.com/kakyire
 */
interface DictionaryService {

    @GET("en/{word}")
    suspend fun getWord(@Path("word") word: String): DictionaryResponse
}