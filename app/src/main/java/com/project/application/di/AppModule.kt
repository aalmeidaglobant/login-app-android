package com.project.application.di

import com.project.login.domain.PerformLoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePerformLoginUseCase(): PerformLoginUseCase {
        return PerformLoginUseCase()
    }
}