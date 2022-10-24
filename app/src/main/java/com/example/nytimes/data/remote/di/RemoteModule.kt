package com.example.nytimes.data.remote.di

import com.example.nytimes.data.remote.datasource.MostPopularArticlesRemoteDataSource
import com.example.nytimes.data.remote.datasource.datasourceimpl.MostPopularArticlesRemoteDataSourceImpl
import com.example.nytimes.data.remote.network.ApiClients
import com.example.nytimes.data.remote.network.interceptor.AuthInterceptor
import com.example.nytimes.data.repo.MostPopularArticlesRepo
import com.example.nytimes.data.repo.repoimpl.MostPopularArticlesRepoImpl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun remoteModule(baseUrl: String) = module {

    factory<Interceptor> {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        return@single AuthInterceptor()
    }

    factory {
        OkHttpClient.Builder().readTimeout(100, TimeUnit.SECONDS)
            .connectTimeout(100, TimeUnit.SECONDS)
            .addInterceptor(get<Interceptor>())
            .addInterceptor(get<AuthInterceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory {
        get<Retrofit>().create(ApiClients::class.java)
    }

    single<MostPopularArticlesRemoteDataSource> { MostPopularArticlesRemoteDataSourceImpl(apiClients = get()) }
}