package com.sample.marvel_mvvm_flow.di

import com.sample.marvel_mvvm_flow.BuildConfig
import com.sample.marvel_mvvm_flow.data.MarvelApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.math.BigInteger
import java.security.MessageDigest
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                val originalHttpUrl = chain.request().url
                val timestamp = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()).toString()
                val url = originalHttpUrl
                    .newBuilder()
                    .addQueryParameter("apikey", BuildConfig.PUBLIC_API_KEY)
                    .addQueryParameter("ts", timestamp)
                    .addQueryParameter(
                        "hash",
                        md5(timestamp + BuildConfig.PRIVATE_API_KEY + BuildConfig.PUBLIC_API_KEY)
                    )
                    .build()
                request.url(url)
                val response = chain.proceed(request.build())
                return@addInterceptor response
            }
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    // from: https://gist.github.com/dlimpid/68761108b49b7c1ddb84250dfac78495
    private fun md5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideMarvelApi(retrofit: Retrofit): MarvelApi = retrofit.create(MarvelApi::class.java)
}
