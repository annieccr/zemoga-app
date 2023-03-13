package com.example.zemoga_app.di

import com.example.zemoga_app.datasource.RestDataSource
import com.example.zemoga_app.repository.DataRepository
import com.example.zemoga_app.repository.DataRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun dataRepository(repo: DataRepositoryImp) : DataRepository
}