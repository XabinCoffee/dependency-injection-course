package com.techyourchance.dagger2course.screens.common.fragments

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.dependencyinjection.presentation.PresentationModule
import com.techyourchance.dagger2course.common.dependencyinjection.Injector
import com.techyourchance.dagger2course.common.dependencyinjection.presentation.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.dependencyinjection.presentation.PresentationComponent
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity

open class BaseFragment: Fragment() {

    private val presentationComponent: PresentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule((requireActivity() as BaseActivity).activityComponent))
            .build()
    }

    protected val injector get() = Injector(presentationComponent)
}