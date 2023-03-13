package com.example.zemoga_app.di

import android.content.Context
import androidx.room.Room
import com.example.zemoga_app.datasource.DbDataSource
import com.example.zemoga_app.datasource.RestDataSource
import com.example.zemoga_app.postList.ui.model.room.CommentDao
import com.example.zemoga_app.postList.ui.model.room.PostDao
import com.example.zemoga_app.postList.ui.model.room.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {
    @Singleton
    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl() = "https://jsonplaceholder.typicode.com/"

    @Singleton
    @Provides
    fun provideRetrofit(@Named("BaseUrl") baseUrl:String): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }
    @Singleton
    @Provides
    fun restDataSource (retrofit: Retrofit): RestDataSource = retrofit.create(RestDataSource::class.java)

    @Singleton
    @Provides
    fun dbDataSource(@ApplicationContext context: Context) : DbDataSource {
        return Room.databaseBuilder(context, DbDataSource::class.java, "zemoga_app")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun commentDao(db: DbDataSource): CommentDao = db.commentDao()

    @Singleton
    @Provides
    fun userDao (db: DbDataSource): UserDao = db.userDao()

    @Singleton
    @Provides
    fun postDao (db: DbDataSource): PostDao = db.postDao()
}