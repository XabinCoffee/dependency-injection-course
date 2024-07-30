package com.techyourchance.dagger2course.common.dependencyinjection.service

import android.app.Service
import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import dagger.Module
import dagger.Provides


@Module
class ServiceModule(
    private val service: Service
) {

    @Provides
    fun context(): Context = service

}