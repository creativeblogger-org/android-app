package org.creativeblogger.org.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.creativeblogger.org.data.remote.Api
import org.creativeblogger.org.data.repository.MyRepositoryImpl
import org.creativeblogger.org.domain.repository.MyRepository
import org.creativeblogger.org.screens.API_URL
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApi(): Api {
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideMyRepository(api: Api): MyRepository {
        return MyRepositoryImpl(api)
    }
}