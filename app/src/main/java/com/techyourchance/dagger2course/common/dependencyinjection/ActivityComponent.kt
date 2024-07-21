package com.techyourchance.dagger2course.common.dependencyinjection

import android.app.Application
import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import dagger.Component
import dagger.Provides


@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    fun screensNavigator(): ScreensNavigator

    fun application(): Application

    fun layoutInflater(): LayoutInflater

    fun fragmentManager(): FragmentManager

    fun stackoverflowApi(): StackoverflowApi
}