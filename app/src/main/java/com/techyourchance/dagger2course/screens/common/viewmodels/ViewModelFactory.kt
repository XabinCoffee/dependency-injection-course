package com.techyourchance.dagger2course.screens.common.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.techyourchance.dagger2course.screens.viewmodel.MyViewModel
import com.techyourchance.dagger2course.screens.viewmodel.MyViewModel2
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val providers: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val provider = providers[modelClass]

        if (provider != null) {
            return provider.get() as T
        } else {
            throw RuntimeException("Unsupported ViewModel type: $modelClass")
        }
    }
}