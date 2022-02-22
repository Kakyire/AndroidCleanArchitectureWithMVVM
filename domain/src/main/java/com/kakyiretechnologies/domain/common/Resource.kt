package com.kakyiretechnologies.domain.common

/**
 * Created by Daniel Frimpong on February 08, 2022.
 * https://github.com/kakyire
 */
sealed class Resource<T>(val data: T? = null, val message: String? = null) {

    class Loading<T> : Resource<T>()
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(message: String) : Resource<T>(message = message)
}
