package com.sixoutoften.domain.use_case

import com.sixoutoften.domain.common.Result
import com.sixoutoften.domain.model.Document
import com.sixoutoften.domain.repository.DocumentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllDocumentsUseCase @Inject constructor(
    private val documentRepository: DocumentRepository
) {
    operator fun invoke(): Flow<Result<List<Document>>> = flow {
        emit(Result.Loading())
        emit(documentRepository.getAll())
    }
}