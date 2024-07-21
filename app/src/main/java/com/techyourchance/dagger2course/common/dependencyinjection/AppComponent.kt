package com.techyourchance.dagger2course.common.dependencyinjection

import android.app.Application
import com.techyourchance.dagger2course.Constants
import com.techyourchance.dagger2course.networking.StackoverflowApi
import dagger.Component
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Component(modules = [AppModule::class])
interface AppComponent {
    fun application(): Application
    fun stackoverflowApi(): StackoverflowApi
}