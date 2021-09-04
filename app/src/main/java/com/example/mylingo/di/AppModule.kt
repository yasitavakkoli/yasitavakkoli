package com.example.mylingo.di

import com.example.mylingo.api.itemsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit():Retrofit=
        Retrofit.Builder()
            .baseUrl(itemsApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideitemsApi(retrofit:Retrofit):itemsApi =
        retrofit.create(itemsApi::class.java)
}