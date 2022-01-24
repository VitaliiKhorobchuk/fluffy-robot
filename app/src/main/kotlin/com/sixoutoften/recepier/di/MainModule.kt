package com.sixoutoften.recepier.di

import com.sixoutoften.recepier.temp.analytics.AnalyticsService
import com.sixoutoften.recepier.temp.analytics.FirebaseAnalyticsService
import com.sixoutoften.recepier.util.RLogger
import com.sixoutoften.recepier.util.TimberLogger
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MainModule {

    @Binds
    abstract fun bindRLogger(
        timberLogger: TimberLogger
    ): RLogger

    @Binds
    abstract fun bindAnalyticsService(
        analyticsService: FirebaseAnalyticsService
    ): AnalyticsService
}