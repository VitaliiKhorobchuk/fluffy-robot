package com.sixoutoften.recepier.di

import com.sixoutoften.recepier.temp.domain.repository.DocumentRepository
import com.sixoutoften.recepier.temp.data.repository.DocumentRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindDocumentRepository(documentRepositoryImpl: DocumentRepositoryImpl): DocumentRepository
}