package com.kakyiretechnologies.dictionary_cleanarchitecturewithmvvm.di

import com.kakyiretechnologies.data.repositories.DictionaryRepositoryImpl
import com.kakyiretechnologies.domain.repositories.DictionaryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Created by Daniel Frimpong on February 08, 2022.
 * https://github.com/kakyire
 */

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindDictionaryRepository(dictionaryRepositoryImpl: DictionaryRepositoryImpl): DictionaryRepository
}