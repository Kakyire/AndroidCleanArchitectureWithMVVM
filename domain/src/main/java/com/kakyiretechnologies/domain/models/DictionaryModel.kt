package com.kakyiretechnologies.domain.models

import androidx.annotation.Keep

/**
 * Created by Daniel Frimpong on February 08, 2022.
 * https://github.com/kakyire
 */

@Keep
data class DictionaryModel(
    val phonetic: String? = "",
    val origin: String? = ""
)
