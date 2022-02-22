package com.kakyiretechnologies.dictionary_cleanarchitecturewithmvvm.di

import com.kakyiretechnologies.data.api.DictionaryService
import com.kakyiretechnologies.domain.common.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Daniel Frimpong on February 08, 2022.
 * https://github.com/kakyire
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @Provides
    @Singleton
    fun provideDictionaryService(retrofit: Retrofit): DictionaryService =
        retrofit.create(DictionaryService::class.java)
}