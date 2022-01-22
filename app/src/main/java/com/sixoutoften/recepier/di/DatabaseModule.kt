package com.sixoutoften.recepier.di

import android.content.Context
import androidx.room.Room
import com.sixoutoften.recepier.temp.data.db.RecepierDB
import com.sixoutoften.recepier.temp.data.db.document.DocumentDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): RecepierDB {
        return Room.databaseBuilder(
            appContext,
            RecepierDB::class.java,
            "Recepier_DB"
        ).build()
    }

    @Provides
    fun provideDocumentDao(appDatabase: RecepierDB): DocumentDao {
        return appDatabase.documentDao()
    }
}