package com.techyourchance.dagger2course.common.dependencyinjection

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(
    private val activity: AppCompatActivity,
    private val appComponent: AppComponent
) {

    private val screensNavigator by lazy {
        ScreensNavigator(activity)
    }

    @Provides
    fun activity() = activity

    @Provides
    fun screensNavigator(activity: AppCompatActivity) = screensNavigator

    @Provides
    fun application() = appComponent.application()

    @Provides
    fun layoutInflater() = LayoutInflater.from(activity)

    @Provides
    fun fragmentManager() = activity.supportFragmentManager

    @Provides
    fun stackoverflowApi() = appComponent.stackoverflowApi()
}