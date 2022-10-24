package com.example.nytimes.data.repo

sealed class Resource<out T> {
    data class Success<out T>(
        val data: T,
        val code: Int? = null
    ) : Resource<T>()

    data class Error<out T>(
        val message: String? = null,
        val data: T? = null,
        val code: Int? = null
    ) : Resource<T>()

    data class Loading<out T>(
        val data: T?
    ) : Resource<T>()
}