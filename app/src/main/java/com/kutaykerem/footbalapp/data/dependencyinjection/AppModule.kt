package com.kutaykerem.footbalapp.data.dependencyinjection

import com.google.gson.Gson
import com.kutaykerem.footbalapp.data.remote.FootballAPI
import com.kutaykerem.footbalapp.data.reporsitory.FootballRepositoryIMPL
import com.kutaykerem.footbalapp.domain.repository.FootballRepository
import com.kutaykerem.footbalapp.util.Contains
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule{


    @Provides
    @Singleton
    fun providerRetrofit(): FootballAPI{
        return Retrofit.Builder()
            .baseUrl(Contains.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FootballAPI::class.java)

    }



    @Provides
    @Singleton
    fun providerFootballRepository(api:FootballAPI): FootballRepository{
        return FootballRepositoryIMPL(api)
    }
}