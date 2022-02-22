package com.kakyiretechnologies.data.models


import androidx.annotation.Keep

class DictionaryResponse : ArrayList<DictionaryResponse.DictionaryResponseItem>() {
    @Keep
    data class DictionaryResponseItem(
        val word: String, // here
        val phonetic: String, // hɪə
        val phonetics: List<Phonetic>,
        val origin: String, // Old English hēr, of Germanic origin; related to Dutch and German hier, also to he.
        val meanings: List<Meaning>
    ) {
        @Keep
        data class Phonetic(
            val text: String, // hɪə
            val audio: String // //ssl.gstatic.com/dictionary/static/sounds/20200429/here--_gb_1.mp3
        )

        @Keep
        data class Meaning(
            val partOfSpeech: String, // adverb
            val definitions: List<Definition>
        ) {
            @Keep
            data class Definition(
                val definition: String, // in, at, or to this place or position.
                val example: String, // they have lived here most of their lives
                val synonyms: List<String>,
                val antonyms: List<Any>
            )
        }
    }
}