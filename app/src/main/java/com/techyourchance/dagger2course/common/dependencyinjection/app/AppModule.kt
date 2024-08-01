package com.techyourchance.dagger2course.common.dependencyinjection.app

import android.app.Application
import com.techyourchance.dagger2course.Constants
import com.techyourchance.dagger2course.common.dependencyinjection.Retrofit1
import com.techyourchance.dagger2course.common.dependencyinjection.Retrofit2
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.networking.UrlProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {


    @Provides
    @AppScope
    @Retrofit1
    fun retrofit1(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlProvider.getBaseUrl1())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @AppScope
    @Retrofit2
    fun retrofit2(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlProvider.getOtherUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun application() = application

    @Provides
    @AppScope
    fun urlProvider() = UrlProvider()

    @Provides
    @AppScope
    fun stackoverflowApi(@Retrofit1 retrofit: Retrofit) = retrofit.create(StackoverflowApi::class.java)

}

