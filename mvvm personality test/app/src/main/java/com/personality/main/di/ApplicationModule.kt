package com.personality.main.di

import android.content.Context
import com.personality.main.category.CategoryUseCase
import com.personality.main.service.VolleyService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun providesNetworkRequestUseCase(
        context: Context,
        volleyService: VolleyService
    ): CategoryUseCase {
        return CategoryUseCase(context, volleyService)
    }

    @Provides
    @Singleton
    fun providesVolleyService(): VolleyService {
        return VolleyService
    }

    @Provides
    fun providesContext(@ApplicationContext context: Context): Context {
        return context
    }
}